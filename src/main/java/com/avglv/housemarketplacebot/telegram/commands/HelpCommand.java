package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.common.command.CommandHandler;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class HelpCommand extends BaseCommand {

    public HelpCommand() {
        super("help", "Помощь по командам бота",
                Set.of(RoleEnum.UNKNOWN, RoleEnum.ADMIN, RoleEnum.CUSTOMER, RoleEnum.SUPPLIER));
    }

    private String getHelpText() {
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
