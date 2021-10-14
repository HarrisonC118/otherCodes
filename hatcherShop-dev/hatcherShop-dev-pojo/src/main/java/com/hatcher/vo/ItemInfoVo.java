package com.hatcher.vo;

import com.hatcher.entity.Items;
import com.hatcher.entity.ItemsImg;
import com.hatcher.entity.ItemsParam;
import com.hatcher.entity.ItemsSpec;

import java.util.List;

/**
 * 商品详情vo
 *
 * @author: HatcherCheung
 * Date:  2021/10/14
 */
public class ItemInfoVo {
    private Items item;
    private List<ItemsImg> itemImgList;
    private List<ItemsSpec> itemsSpecList;
    private ItemsParam itemsParam;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

    public List<ItemsSpec> getItemsSpecList() {
        return itemsSpecList;
    }

    public void setItemsSpecList(List<ItemsSpec> itemsSpecList) {
        this.itemsSpecList = itemsSpecList;
    }

    public ItemsParam getItemsParam() {
        return itemsParam;
    }

    public void setItemsParam(ItemsParam itemsParam) {
        this.itemsParam = itemsParam;
    }

}
