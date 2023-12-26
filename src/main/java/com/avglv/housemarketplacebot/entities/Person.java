package com.avglv.housemarketplacebot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Person {
    @Id
    private Long id;
    private String userName;
    private String lastName;
    private String firstName;

    public Person(org.telegram.telegrambots.meta.api.objects.User telegramUser) {
        this.id = telegramUser.getId();
        this.userName = telegramUser.getUserName();
        this.firstName = telegramUser.getFirstName();
        this.lastName = telegramUser.getLastName();
    }
}
