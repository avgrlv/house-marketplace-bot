package com.avglv.housemarketplacebot.common.callback;

import com.avglv.housemarketplacebot.common.Applicable;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

public abstract class BaseCallback implements Applicable {

    @Override
    public SendMessage apply(Update update, Set<RoleEnum> userRoles) {
        return apply(update, userRoles);
    }
}
