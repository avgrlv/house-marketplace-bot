package com.avglv.housemarketplacebot.common;

import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Set;

public interface PermissionVerifiable {

    boolean verify(Set<RoleEnum> userRoles);

    default SendMessage permissionDenied(Long chatId, String helpText) {
        return SendMessage.builder().chatId(chatId)
                .text("Недостаточно прав для выполнения данной команды.\n\n" + helpText)
                .build();
    }
}
