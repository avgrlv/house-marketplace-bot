package com.avglv.housemarketplacebot.telegram.commands;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import com.avglv.housemarketplacebot.services.PersonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

@Component
public class StartCommand extends BaseCommand {
    @Autowired
    private PersonService personService;

    public StartCommand() {
        super("start", "Запуск бота",
                Set.of(RoleEnum.UNKNOWN, RoleEnum.ADMIN, RoleEnum.CUSTOMER, RoleEnum.SUPPLIER)
        );
    }

    @Transactional
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();
        msg.setChatId(getChatId());
        msg.setText("Бот запущен. Добро пожаловать " + getTelegramUser().getLastName()
                + " " + getTelegramUser().getFirstName() + "!");
        return msg;
    }
}
