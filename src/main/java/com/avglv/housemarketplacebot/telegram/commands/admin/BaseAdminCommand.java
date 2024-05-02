package com.avglv.housemarketplacebot.telegram.commands.admin;

import com.avglv.housemarketplacebot.common.command.BaseCommand;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import com.avglv.housemarketplacebot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Set;

@Component
public class BaseAdminCommand extends BaseCommand {

    @Autowired
    private PersonRepository personRepository;

    public BaseAdminCommand() {
        super("admin", "Панель администратора", Set.of(RoleEnum.ADMIN));
    }

    @Override
    public SendMessage handle(Update update) {
        return null;
    }
}
