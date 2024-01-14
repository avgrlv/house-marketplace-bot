package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.common.command.CommandHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.stream.Collectors;

@Component
public class HelpCommand extends BaseCommand {
    public HelpCommand() {
        super("help", "Помощь по командам бота");
    }
    public static String getHelpText() {
        return "Доступные команды бота:\n" +
                CommandHandler.getCommands().entrySet()
                        .stream()
                        .map(entry -> entry.getKey() + " - "
                                + entry.getValue().getDescription())
                        .collect(Collectors.joining("\n"));
    }


    @Override
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(getChatId());
        msg.setText(getHelpText());
        return msg;
    }
}
