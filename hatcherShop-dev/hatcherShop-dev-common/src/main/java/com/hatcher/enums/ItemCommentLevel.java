package com.hatcher.enums;

/**
 * @author: HatcherCheung
 * Date:  2021/10/16
 */
public enum ItemCommentLevel {
    good(1, "好评"),
    normal(2, "中评"),
    bad(3, "差评");
    public final Integer type;
    public final String value;

    ItemCommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
