package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

@Component
public class StopCommand extends BaseCommand {

    public StopCommand() {
        super("stop", "Завершить работу бота", Set.of(RoleEnum.UNKNOWN, RoleEnum.CUSTOMER));
    }

    @Override
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(getChatId());
        msg.setText("Бот остановлен. Хорошего дня " + getTelegramUser().getLastName()
                + " " + getTelegramUser().getFirstName() + "!");
        return msg;
    }
}
