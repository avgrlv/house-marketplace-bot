package com.avglv.housemarketplacebot.common.command;

import com.avglv.housemarketplacebot.entities.Person;
import com.avglv.housemarketplacebot.entities.Role;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import com.avglv.housemarketplacebot.repositories.PersonRepository;
import com.avglv.housemarketplacebot.services.PersonService;
import com.google.common.collect.Sets;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Log4j2
public class CommandHandler {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @Getter
    public static final Map<String, BaseCommand> commands = new HashMap<>();

    public CommandHandler(Set<BaseCommand> commands) {
        commands.forEach((command) -> CommandHandler.commands.put(command.getCommandNameFull(), command));
    }

    @Transactional
    public SendMessage handleCommand(Update update) {
        String commandName = update.getMessage().getText().split(" ")[0];
        BaseCommand command = CommandHandler.commands.get(commandName);
        if (command == null)
            return unknownCommand(update.getMessage().getChatId());
        Person person = personRepository
                .findById(update.getMessage().getFrom().getId())
                .orElse(null);
        if (person == null) {
            person = this.personService.createUser(update.getMessage().getFrom());
        }

        Set<RoleEnum> userRole = person.getRoles()
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());

        if (Sets.intersection(command.getAvailableRoles(), userRole).isEmpty())
            return permissionDenied(update.getMessage().getChatId());

        return command.apply(update, userRole);
    }

    private SendMessage permissionDenied(Long chatId) {
        return SendMessage.builder().chatId(chatId)
                .text("Недостаточно прав для выполнения данной команды")
                .build();
    }


    private SendMessage unknownCommand(Long chatId) {
        return SendMessage.builder().chatId(chatId)
                .text("Неизвестная команда. " +
                        "Список достпуных команд вы можете посмотреть при помощи /help")
                .build();
    }
}
