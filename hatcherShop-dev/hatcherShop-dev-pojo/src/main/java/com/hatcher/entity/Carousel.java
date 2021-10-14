package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 轮播图
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@ApiModel(value = "Carousel对象", description = "轮播图 ")
public class Carousel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId
    private String id;

    @ApiModelProperty("图片 图片地址")
    private String imageUrl;

    @ApiModelProperty("背景色")
    private String backgroundColor;

    @ApiModelProperty("商品id 商品id")
    private String itemId;

    @ApiModelProperty("商品分类id 商品分类id")
    private String catId;

    @ApiModelProperty("轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类")
    private Integer type;

    @ApiModelProperty("轮播图展示顺序")
    private Integer sort;

    @ApiModelProperty("是否展示")
    private Integer isShow;

    @ApiModelProperty("创建时间 创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间 更新")
    private LocalDateTime updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", imageUrl=" + imageUrl +
                ", backgroundColor=" + backgroundColor +
                ", itemId=" + itemId +
                ", catId=" + catId +
                ", type=" + type +
                ", sort=" + sort +
                ", isShow=" + isShow +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
