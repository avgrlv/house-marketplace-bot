package com.avglv.housemarketplacebot.common;

import com.avglv.housemarketplacebot.entities.Role;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

public interface Applicable {
    SendMessage apply(Update update, Set<Role> personRoles);

    SendMessage handle(Update update);

}
