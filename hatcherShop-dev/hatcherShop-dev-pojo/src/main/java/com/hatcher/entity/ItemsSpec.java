package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("items_spec")
@ApiModel(value = "ItemsSpec对象", description = "商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计")
public class ItemsSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品规格id")
    @TableId
    private String id;

    @ApiModelProperty("商品外键id")
    private String itemId;

    @ApiModelProperty("规格名称")
    private String name;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("折扣力度")
    private BigDecimal discounts;

    @ApiModelProperty("优惠价")
    private Integer priceDiscount;

    @ApiModelProperty("原价")
    private Integer priceNormal;

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getDiscounts() {
        return discounts;
    }

    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    public Integer getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Integer priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public Integer getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
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
        return "ItemsSpec{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", name=" + name +
                ", stock=" + stock +
                ", discounts=" + discounts +
                ", priceDiscount=" + priceDiscount +
                ", priceNormal=" + priceNormal +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
