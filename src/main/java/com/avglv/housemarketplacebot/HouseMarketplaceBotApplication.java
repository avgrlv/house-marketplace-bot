package com.avglv.housemarketplacebot;

import com.avglv.housemarketplacebot.telegram.HouseMarketplaceBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@Log4j2
public class HouseMarketplaceBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseMarketplaceBotApplication.class, args);
    }
}
