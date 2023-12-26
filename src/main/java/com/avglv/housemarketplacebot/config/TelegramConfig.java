package com.avglv.housemarketplacebot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TelegramConfig {
    @Value("${telegram.bot.house-marketplace.token}")
    private String token;
    @Value("${telegram.bot.house-marketplace.name}")
    private String name;
    @Value("${telegram.bot.house-marketplace.webhook-path}")
    private String webhookPath;
}
