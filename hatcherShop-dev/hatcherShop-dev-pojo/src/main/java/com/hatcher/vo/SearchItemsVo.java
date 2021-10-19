package com.hatcher.vo;

/**
 * @author: HatcherCheung
 * Date:  2021/10/19
 */
public class SearchItemsVo {
    private String itemId;
    private String itemName;
    private int sellCounts;
    private String imgUrl;
    /**
     * 单位是分
     */
    private int price;

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

    public int getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(int cellCounts) {
        this.sellCounts = cellCounts;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
