package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.services.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand extends BaseCommand {
    @Autowired
    private PersonService personService;

    public StartCommand() {
        super("start", "Запуск бота");
    }

    @Transactional
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();
        this.personService.createUser(getTelegramUser());
        msg.setChatId(getChatId());
        msg.setText("Бот запущен. Добро пожаловать " + getTelegramUser().getLastName()
                + " " + getTelegramUser().getFirstName() + "!");
        return msg;
    }
}
