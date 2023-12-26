package com.avglv.housemarketplacebot.common;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Data
@Log4j2
public abstract class BaseCommand implements Command {
    String name;
    String description;

    Long chatId;
    User telegramUser;

    public BaseCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static String getCommand(BaseCommand command) {
        return "/" + command.name;
    }

    public static SendMessage unknownCommand(Long chatId) {
        return SendMessage.builder().chatId(chatId)
                .text("Неизвестная команда. " +
                        "Список достпуных команд вы можете посмотреть при помощи /help")
                .build();
    }


}
