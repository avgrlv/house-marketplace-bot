package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.BaseCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand extends BaseCommand {

    public StartCommand() {
        super("start", "Запуск бота");
    }

    @Override
    public SendMessage apply(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(getChatId());
        msg.setText("Бот запущен");
        return msg;
    }
}
