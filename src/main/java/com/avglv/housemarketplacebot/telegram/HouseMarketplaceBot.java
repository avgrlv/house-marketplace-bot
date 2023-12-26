package com.avglv.housemarketplacebot.telegram;

import com.avglv.housemarketplacebot.common.CommandHandler;
import com.avglv.housemarketplacebot.config.TelegramConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.Consts;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Log4j2
public class HouseMarketplaceBot extends TelegramLongPollingBot {
    TelegramConfig config;
    CommandHandler commandHandler;

    public HouseMarketplaceBot(TelegramConfig config, CommandHandler commandHandler) {
        super(new DefaultBotOptions(), config.getToken());
        this.config = config;
        this.commandHandler = commandHandler;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            sendMessage(commandHandler.handleCommand(update));
        } else if (update.hasCallbackQuery()) {
            //sendMessage(callbacksHandler.handleCallbacks(update));
        }
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }
}
