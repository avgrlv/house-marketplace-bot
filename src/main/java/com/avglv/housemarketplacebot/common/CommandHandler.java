package com.avglv.housemarketplacebot.common;

import lombok.extern.log4j.Log4j2;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
public class CommandHandler {
    private final Map<String, BaseCommand> commands = new HashMap<>();

    public CommandHandler(BaseCommand... commands) {
        for (BaseCommand command : commands) {
            this.commands.put(BaseCommand.getCommand(command), command);
        }
    }

    public SendMessage handleCommand(Update update) {
        if (update.hasMessage() && update.getMessage().isCommand()) {
            String commandName = update.getMessage().getText().split(" ")[0];
            BaseCommand command = this.commands.get(commandName);
            return command.apply(update);
        } else {
            return BaseCommand.unknownCommand(update.getMessage().getChatId());
        }
    }
}
