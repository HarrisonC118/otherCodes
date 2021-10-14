package com.hatcher.vo;

import java.util.List;

/**
 * 最新商品的VO
 *
 * @author: HatcherCheung
 * Date:  2021/10/14
 */
public class ItemsVo {
    private String rootCarId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;
    private List<SimpleItemVo> simpleItemVoList;

    public String getRootCarId() {
        return rootCarId;
    }

    public void setRootCarId(String rootCarId) {
        this.rootCarId = rootCarId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<SimpleItemVo> getSimpleItemVoList() {
        return simpleItemVoList;
    }

    public void setSimpleItemVoList(List<SimpleItemVo> simpleItemVoList) {
        this.simpleItemVoList = simpleItemVoList;
    }
}
