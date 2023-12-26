package com.avglv.housemarketplacebot.config;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

@Data
public class HouseMarketplaceCommands {
    public HouseMarketplaceCommands() {
        COMMAND_LIST.add(new BotCommand("/start", "Запуск бота"));
        COMMAND_LIST.add(new BotCommand("/help", "Помощь"));
        COMMAND_LIST.add(new BotCommand("/mydata", "Мои данные"));
    }

    private List<BotCommand> COMMAND_LIST = new ArrayList<>();
}
