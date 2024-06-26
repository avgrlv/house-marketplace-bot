package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand extends BaseCommand {

    public StartCommand() {
        super("start", "Запуск бота", RoleEnum.getAllRole());
    }

    @Override
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(getChatId());
        msg.setText("Бот запущен. Добро пожаловать " + getTelegramUser().getLastName()
                + " " + getTelegramUser().getFirstName() + "!");
        return msg;
    }
}
