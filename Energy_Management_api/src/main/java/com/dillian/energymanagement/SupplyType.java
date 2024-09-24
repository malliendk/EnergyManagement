package com.dillian.energymanagement;

import lombok.Getter;

@Getter
public enum SupplyType {

    SHORTAGE("SHORTAGE"),
    OPTIMAL("OPTIMAL"),
    SURPLUS("SURPLUS");

    private final String value;

    SupplyType(String value) {
        this.value = value;
    }
}
