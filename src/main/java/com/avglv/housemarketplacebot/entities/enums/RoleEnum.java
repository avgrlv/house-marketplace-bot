package com.avglv.housemarketplacebot.entities.enums;

import java.util.Set;

public enum RoleEnum {
    UNKNOWN, ADMIN, CUSTOMER, SUPPLIER;

    public static Set<RoleEnum> getAllRole() {
        return Set.of(RoleEnum.values());
    }
}
