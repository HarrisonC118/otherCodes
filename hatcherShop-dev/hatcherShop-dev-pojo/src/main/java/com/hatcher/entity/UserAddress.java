package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户地址表
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("user_address")
@ApiModel(value = "UserAddress对象", description = "用户地址表 ")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("地址主键id")
    private String id;

    @ApiModelProperty("关联用户id")
    private String userId;

    @ApiModelProperty("收件人姓名")
    private String receiver;

    @ApiModelProperty("收件人手机号")
    private String mobile;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("区县")
    private String district;

    @ApiModelProperty("详细地址")
    private String detail;

    @ApiModelProperty("扩展字段")
    private String extand;

    @ApiModelProperty("是否默认地址")
    private Integer isDefault;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", receiver=" + receiver +
                ", mobile=" + mobile +
                ", province=" + province +
                ", city=" + city +
                ", district=" + district +
                ", detail=" + detail +
                ", extand=" + extand +
                ", isDefault=" + isDefault +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
