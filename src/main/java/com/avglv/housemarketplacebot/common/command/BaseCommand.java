package com.avglv.housemarketplacebot.common.command;

import com.avglv.housemarketplacebot.common.Applicable;
import com.avglv.housemarketplacebot.common.PermissionVerifiable;
import com.avglv.housemarketplacebot.entities.Role;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Log4j2
public abstract class BaseCommand implements Applicable, PermissionVerifiable {
    private String name;
    private String description;
    private Long chatId;
    private User telegramUser;
    private Set<RoleEnum> availableRoles;

    public BaseCommand(String name,
                       String description,
                       Set<RoleEnum> availableRoles) {
        this.name = name;
        this.description = description;
        this.availableRoles = availableRoles;
    }

    public String getCommand() {
        return "/" + this.name;
    }

    public String getHelpText(Set<RoleEnum> userRoles) {
        return "Доступные команды бота:\n" +
                CommandHandler.getCommands().entrySet()
                        .stream()
                        .filter(e -> e.getValue().getAvailableRoles()
                                .stream().anyMatch(userRoles::contains))
                        .map(entry -> entry.getKey() + " - "
                                + entry.getValue().getDescription())
                        .collect(Collectors.joining("\n"));
    }

    @Override
    public SendMessage apply(Update update, Set<Role> personRoles) {
        this.chatId = update.getMessage().getChatId();
        this.telegramUser = update.getMessage().getFrom();

        Set<RoleEnum> userRoles = personRoles
                .stream()
                .map(Role::getRole)
                .collect(Collectors.toSet());

        if (verify(userRoles))
            return permissionDenied(update.getMessage().getChatId(), getHelpText(userRoles));

        return handle(update);
    }


    @Override
    public boolean verify(Set<RoleEnum> userRoles) {
        return Sets.intersection(this.availableRoles, userRoles).isEmpty();
    }

}
