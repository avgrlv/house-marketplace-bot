package com.avglv.housemarketplacebot.common;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Applyable{
    SendMessage apply(Update update);
    SendMessage handle(Update update);

}
