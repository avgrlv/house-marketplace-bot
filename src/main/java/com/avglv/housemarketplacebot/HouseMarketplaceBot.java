package com.avglv.housemarketplacebot;

import com.avglv.housemarketplacebot.config.TelegramConfig;
import com.avglv.housemarketplacebot.controllers.ResponseHandler;
import com.avglv.housemarketplacebot.dto.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

@Component
public class HouseMarketplaceBot extends AbilityBot {

    private ResponseHandler responseHandler;

    @Autowired
    public HouseMarketplaceBot(TelegramConfig botConfig) {
        super(botConfig.getToken(), botConfig.getName());
        this.responseHandler = new ResponseHandler(silent, db);
    }

    public Ability startBot() {
        return Ability
                .builder()
                .name("start")
                .info(Constants.START_DESCRIPTION)
                .locality(USER)
                .privacy(PUBLIC)
                .action(ctx -> responseHandler.replyToStart(ctx.chatId()))
                .build();
    }

    @Override
    public long creatorId() {
        return 1L;
    }
}
