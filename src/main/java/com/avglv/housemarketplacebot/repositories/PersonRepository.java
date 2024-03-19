package com.avglv.housemarketplacebot.repositories;

import com.avglv.housemarketplacebot.entities.Person;
import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telegram.telegrambots.meta.api.objects.User;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    default boolean isAdmin(User telegramUser) {
        return this.findById(telegramUser.getId())
                .stream()
                .map(Person::getRoles)
                .anyMatch(r -> r.equals(RoleEnum.ADMIN));
    }
}
