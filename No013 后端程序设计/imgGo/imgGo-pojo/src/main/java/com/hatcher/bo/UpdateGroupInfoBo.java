package com.hatcher.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/6
 * @Description:
 */
@ApiModel("修改分组信息的对象")
public class UpdateGroupInfoBo {
	@ApiModelProperty("分组ID")
	private String groupId;
	@ApiModelProperty("分组名")
	private String groupName;
	@ApiModelProperty("分组内容")
	private String groupContent;

	@Override
	public String toString() {
		return "UpdateGroupInfoBo{" +
				"groupId='" + groupId + '\'' +
				", groupName='" + groupName + '\'' +
				", groupContent='" + groupContent + '\'' +
				'}';
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
