package com.avglv.housemarketplacebot.services;

import com.avglv.housemarketplacebot.entities.Person;
import com.avglv.housemarketplacebot.entities.enums.Role;
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
    public void createUser(User telegramUser) {
        if (!personRepository.existsById(telegramUser.getId())) {
            Person person = new Person(telegramUser, Role.CUSTOMER);
            personRepository.save(person);
        }
    }

}
