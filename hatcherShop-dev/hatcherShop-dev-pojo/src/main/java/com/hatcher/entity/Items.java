package com.hatcher.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@ApiModel(value = "Items对象", description = "商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表")
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品主键id")
    private String id;

    @ApiModelProperty("商品名称 商品名称")
    private String itemName;

    @ApiModelProperty("分类外键id 分类id")
    private Integer catId;

    @ApiModelProperty("一级分类外键id")
    private Integer rootCatId;

    @ApiModelProperty("累计销售 累计销售")
    private Integer sellCounts;

    @ApiModelProperty("上下架状态 上下架状态,1:上架 2:下架")
    private Integer onOffStatus;

    @ApiModelProperty("商品内容 商品内容")
    private String content;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public Integer getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    public Integer getOnOffStatus() {
        return onOffStatus;
    }

    public void setOnOffStatus(Integer onOffStatus) {
        this.onOffStatus = onOffStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemName=" + itemName +
                ", catId=" + catId +
                ", rootCatId=" + rootCatId +
                ", sellCounts=" + sellCounts +
                ", onOffStatus=" + onOffStatus +
                ", content=" + content +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
