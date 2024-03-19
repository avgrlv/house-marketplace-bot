package com.avglv.housemarketplacebot.services;

import com.avglv.housemarketplacebot.entities.Person;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import com.avglv.housemarketplacebot.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person createUser(User telegramUser) {
        Person person = new Person(telegramUser, RoleEnum.UNKNOWN);
        personRepository.save(person);
        return person;
    }

}
