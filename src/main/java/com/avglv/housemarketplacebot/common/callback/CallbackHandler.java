package com.avglv.housemarketplacebot.common.callback;

import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

public class CallbackHandler extends BaseCallback{

    public SendMessage handle(Update update, Set<RoleEnum> userRoles) {
        return null;
    }
}
