package com.avglv.housemarketplacebot.common.command;

import com.avglv.housemarketplacebot.common.Applyable;
import com.avglv.housemarketplacebot.entities.enums.Role;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Data
@Log4j2
public abstract class BaseCommand implements Applyable {
    String name;
    String description;
    Long chatId;
    User telegramUser;

    public BaseCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getCommandNameFull() {
        return "/" + this.name;
    }

    public static SendMessage unknownCommand(Long chatId) {
        return SendMessage.builder().chatId(chatId)
                .text("Неизвестная команда. " +
                        "Список достпуных команд вы можете посмотреть при помощи /help")
                .build();
    }

    public SendMessage apply(Update update) {
        this.chatId = update.getMessage().getChatId();
        this.telegramUser = update.getMessage().getFrom();
        return handle(update);
    }
}
