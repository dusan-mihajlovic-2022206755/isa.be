package com.ISAProjekat.dusanm.enums;

public enum RoleEnum {
    ADMINISTRATOR(1),
    EMPLOYEE(2);

    private final int value;

    RoleEnum(int value) {
        this.value = value;
    }
    public int getValue() {return value;}
}