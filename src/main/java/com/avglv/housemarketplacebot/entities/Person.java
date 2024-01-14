package com.avglv.housemarketplacebot.entities;

import com.avglv.housemarketplacebot.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private Role role;

    public Person(org.telegram.telegrambots.meta.api.objects.User telegramUser, Role role) {
        this.id = telegramUser.getId();
        this.userName = telegramUser.getUserName();
        this.firstName = telegramUser.getFirstName();
        this.lastName = telegramUser.getLastName();
        this.role = role;
    }
}
