package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品参数
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("items_param")
@ApiModel(value = "ItemsParam对象", description = "商品参数 ")
public class ItemsParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品参数id")
    @TableId
    private String id;

    @ApiModelProperty("商品外键id")
    private String itemId;

    @ApiModelProperty("产地 产地，例：中国江苏")
    private String producPlace;

    @ApiModelProperty("保质期 保质期，例：180天")
    private String footPeriod;

    @ApiModelProperty("品牌名 品牌名，例：三只大灰狼")
    private String brand;

    @ApiModelProperty("生产厂名 生产厂名，例：大灰狼工厂")
    private String factoryName;

    @ApiModelProperty("生产厂址 生产厂址，例：大灰狼生产基地")
    private String factoryAddress;

    @ApiModelProperty("包装方式 包装方式，例：袋装")
    private String packagingMethod;

    @ApiModelProperty("规格重量 规格重量，例：35g")
    private String weight;

    @ApiModelProperty("存储方法 存储方法，例：常温5~25°")
    private String storageMethod;

    @ApiModelProperty("食用方式 食用方式，例：开袋即食")
    private String eatMethod;

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

    public String getProducPlace() {
        return producPlace;
    }

    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace;
    }

    public String getFootPeriod() {
        return footPeriod;
    }

    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    public String getPackagingMethod() {
        return packagingMethod;
    }

    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    public String getEatMethod() {
        return eatMethod;
    }

    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod;
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
        return "ItemsParam{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", producPlace=" + producPlace +
                ", footPeriod=" + footPeriod +
                ", brand=" + brand +
                ", factoryName=" + factoryName +
                ", factoryAddress=" + factoryAddress +
                ", packagingMethod=" + packagingMethod +
                ", weight=" + weight +
                ", storageMethod=" + storageMethod +
                ", eatMethod=" + eatMethod +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
