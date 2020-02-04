package com.maochengli.enums;

/**
 * 性別枚举
 */
public enum Sex {

    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer sex;
    public final String value;

    Sex(Integer sex, String value) {
        this.sex = sex;
        this.value = value;
    }
}
