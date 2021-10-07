package com.hatcher.enums;

/**
 * @Desc: 枚举类型的性别
 * @author: HatcherCheung
 * Date:  2021/10/6
 */
public enum Sex {

    woman(0, "女"),
    man(1, "男"),
    secret(2, "保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
