package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表;
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@ApiModel(value = "Orders对象", description = "订单表;")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单主键;同时也是订单编号")
    @TableId
    private String id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("收货人快照")
    private String receiverName;

    @ApiModelProperty("收货人手机号快照")
    private String receiverMobile;

    @ApiModelProperty("收货地址快照")
    private String receiverAddress;

    @ApiModelProperty("订单总价格")
    private Integer totalAmount;

    @ApiModelProperty("实际支付总价格")
    private Integer realPayAmount;

    @ApiModelProperty("邮费;默认可以为零，代表包邮")
    private Integer postAmount;

    @ApiModelProperty("支付方式")
    private Integer payMethod;

    @ApiModelProperty("买家留言")
    private String leftMsg;

    @ApiModelProperty("扩展字段")
    private String extand;

    @ApiModelProperty("买家是否评价;1：已评价，0：未评价")
    private Integer isComment;

    @ApiModelProperty("逻辑删除状态;1: 删除 0:未删除")
    private Integer isDelete;

    @ApiModelProperty("创建时间（成交时间）")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getRealPayAmount() {
        return realPayAmount;
    }

    public void setRealPayAmount(Integer realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    public Integer getPostAmount() {
        return postAmount;
    }

    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public String getLeftMsg() {
        return leftMsg;
    }

    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", receiverName=" + receiverName +
                ", receiverMobile=" + receiverMobile +
                ", receiverAddress=" + receiverAddress +
                ", totalAmount=" + totalAmount +
                ", realPayAmount=" + realPayAmount +
                ", postAmount=" + postAmount +
                ", payMethod=" + payMethod +
                ", leftMsg=" + leftMsg +
                ", extand=" + extand +
                ", isComment=" + isComment +
                ", isDelete=" + isDelete +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
