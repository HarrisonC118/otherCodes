package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品评价表
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@TableName("items_comments")
@ApiModel(value = "ItemsComments对象", description = "商品评价表 ")
public class ItemsComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id主键")
    @TableId
    private String id;

    @ApiModelProperty("用户id 用户名须脱敏")
    private String userId;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品名称")
    private String itemName;

    @ApiModelProperty("商品规格id 可为空")
    private String itemSpecId;

    @ApiModelProperty("规格名称 可为空")
    private String sepcName;

    @ApiModelProperty("评价等级 1：好评 2：中评 3：差评")
    private Integer commentLevel;

    @ApiModelProperty("评价内容")
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
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
        return "ItemsComments{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", itemName=" + itemName +
                ", itemSpecId=" + itemSpecId +
                ", sepcName=" + sepcName +
                ", commentLevel=" + commentLevel +
                ", content=" + content +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
