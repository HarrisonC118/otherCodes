package com.hatcher.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: HatcherCheung
 * @Date: 2021/11/16
 * @Description: 添加分组的对象
 */
@ApiModel(value = "添加分组的对象")
public class AddGroupBo {
    @ApiModelProperty("用户Id")
    private String userId;
    @ApiModelProperty("分组名")
    private String groupName;
    @ApiModelProperty("跟组介绍")
    private String groupContent;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupContent() {
        return groupContent;
    }

    public void setGroupContent(String groupContent) {
        this.groupContent = groupContent;
    }
}
