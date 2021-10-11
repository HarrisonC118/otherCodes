package com.hatcher.enums;

/**
 * @author: HatcherCheung
 * Date:  2021/10/11
 */
public enum CarouselIsDisplay {
    yes(1, "是"),
    on(0, "否");

    public final Integer type;
    public final String value;

    CarouselIsDisplay(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
