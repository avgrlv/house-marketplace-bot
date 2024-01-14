package com.avglv.housemarketplacebot.common.callback;

import com.avglv.housemarketplacebot.common.Applyable;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class BaseCallback implements Applyable {

    @Override
    public SendMessage apply(Update update) {
        return apply(update);
    }
}
