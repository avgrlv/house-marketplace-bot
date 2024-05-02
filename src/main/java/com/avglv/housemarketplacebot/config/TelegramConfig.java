package com.avglv.housemarketplacebot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
@Data
public class TelegramConfig {
    @Value("${telegram.bot.house-marketplace.token}")
    private String token;
    @Value("${telegram.bot.house-marketplace.name}")
    private String name;

    @Value("${telegram.proxy.host}")
    private String proxyHost;
    @Value("${telegram.proxy.port}")
    private int proxyPort;

    public DefaultBotOptions proxyConfiguration() {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        botOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);
        botOptions.setProxyHost(proxyHost);
        botOptions.setProxyPort(proxyPort);
        return botOptions;
    }
}
