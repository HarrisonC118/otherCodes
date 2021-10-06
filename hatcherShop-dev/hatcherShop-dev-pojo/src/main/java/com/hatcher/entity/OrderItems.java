package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 订单商品关联表
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("order_items")
@ApiModel(value = "OrderItems对象", description = "订单商品关联表 ")
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("归属订单id")
    private String orderId;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品图片")
    private String itemImg;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("规格id")
    private String itemSpecId;

    @ApiModelProperty("规格名称")
    private String itemSpecName;

    @ApiModelProperty("成交价格")
    private Integer price;

    @ApiModelProperty("购买数量")
    private Integer buyCounts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(Integer buyCounts) {
        this.buyCounts = buyCounts;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", itemId=" + itemId +
                ", itemImg=" + itemImg +
                ", itemName=" + itemName +
                ", itemSpecId=" + itemSpecId +
                ", itemSpecName=" + itemSpecName +
                ", price=" + price +
                ", buyCounts=" + buyCounts +
                "}";
    }
}
