package com.avglv.housemarketplacebot.common.command;

import com.avglv.housemarketplacebot.common.Applicable;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Set;

@Data
@Log4j2
public abstract class BaseCommand implements Applicable {
    String name;
    String description;
    Long chatId;
    User telegramUser;
    Set<RoleEnum> availableRoles;

    public BaseCommand(String name,
                       String description,
                       Set<RoleEnum> availableRoles) {
        this.name = name;
        this.description = description;
        this.availableRoles = availableRoles;
    }

    public String getCommandNameFull() {
        return "/" + this.name;
    }

    @Override
    public SendMessage apply(Update update, Set<RoleEnum> availableRoles) {
        this.chatId = update.getMessage().getChatId();
        this.telegramUser = update.getMessage().getFrom();
        return handle(update, availableRoles);
    }
}
