package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品图片
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("items_img")
@ApiModel(value = "ItemsImg对象", description = "商品图片 ")
public class ItemsImg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("图片主键")
    @TableId
    private String id;

    @ApiModelProperty("商品外键id 商品外键id")
    private String itemId;

    @ApiModelProperty("图片地址 图片地址")
    private String url;

    @ApiModelProperty("顺序 图片顺序，从小到大")
    private Integer sort;

    @ApiModelProperty("是否主图 是否主图，1：是，0：否")
    private Integer isMain;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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
        return "ItemsImg{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", url=" + url +
                ", sort=" + sort +
                ", isMain=" + isMain +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
