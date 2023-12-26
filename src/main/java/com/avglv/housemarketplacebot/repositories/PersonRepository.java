package com.avglv.housemarketplacebot.repositories;

import com.avglv.housemarketplacebot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
