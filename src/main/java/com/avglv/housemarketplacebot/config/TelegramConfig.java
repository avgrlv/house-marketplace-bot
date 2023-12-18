package com.avglv.housemarketplacebot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TelegramConfig {
    @Value("${telegram.bot.house-marketplace.token}")
    private String token;
    @Value("${telegram.bot.house-marketplace.name}")
    private String name;
    @Value("${telegram.bot.house-marketplace.webhook-path}")
    private String webhookPath;
}
