package com.hatcher.vo;

import java.time.LocalDateTime;

/**
 * @author: HatcherCheung
 * Date:  2021/10/14
 */
public class SimpleItemVo {
    private String itemId;
    private String itemName;
    private String itemUrl;
    private LocalDateTime createTime;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
