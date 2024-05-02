package com.avglv.housemarketplacebot.entities;

import com.avglv.housemarketplacebot.entities.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    public Role(RoleEnum role, Person person) {
        this.role = role;
        this.person = person;
    }
}
