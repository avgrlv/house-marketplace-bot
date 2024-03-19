package com.avglv.housemarketplacebot.entities;

import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Person {
    @Id
    private Long id;
    private String userName;
    private String lastName;
    private String firstName;
    @OneToMany(mappedBy = "person", orphanRemoval = true)
    private Set<Role> roles = new HashSet<>();

    public Person(User telegramUser, RoleEnum role) {
        this.id = telegramUser.getId();
        this.userName = telegramUser.getUserName();
        this.firstName = telegramUser.getFirstName();
        this.lastName = telegramUser.getLastName();
        this.addRole(role);
    }

    private void addRole(RoleEnum roleEnum) {
        Role role = new Role(roleEnum, this);
        this.roles.add(role);
    }

    private void revokeRole(RoleEnum role) {
        this.roles.removeIf(r -> r.getRole().equals(role));
    }

    public boolean isAdmin() {
        return roles.stream().anyMatch(r -> r.getRole().equals(RoleEnum.ADMIN));
    }
}
