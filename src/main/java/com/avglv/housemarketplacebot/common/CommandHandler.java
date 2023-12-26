package com.avglv.housemarketplacebot.common;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Log4j2
public class CommandHandler {
    @Getter
    public static final Map<String, BaseCommand> commands = new HashMap<>();

    public CommandHandler(Set<BaseCommand> commands) {
        commands.forEach((command) -> CommandHandler.commands.put(command.getCommandNameFull(), command));
    }

    public SendMessage handleCommand(Update update) {
        String commandName = update.getMessage().getText().split(" ")[0];
        BaseCommand command = CommandHandler.commands.get(commandName);
        if (command == null)
            return BaseCommand.unknownCommand(update.getMessage().getChatId());
        return command.apply(update);
    }
}
