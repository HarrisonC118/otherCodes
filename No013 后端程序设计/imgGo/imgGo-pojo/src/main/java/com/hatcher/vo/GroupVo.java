package com.hatcher.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/10/28
 */
public class GroupVo {
	private String groupName;
	private String groupContent;
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime groupCreateTime;
	private List<ImgVo> imgList;

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


	public LocalDateTime getGroupCreateTime() {
		return groupCreateTime;
	}

	public void setGroupCreateTime(LocalDateTime groupCreateTime) {
		this.groupCreateTime = groupCreateTime;
	}

	public List<ImgVo> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImgVo> imgList) {
		this.imgList = imgList;
	}

	@Override
	public String toString() {
		return "GroupVo{" +
				"groupName='" + groupName + '\'' +
				", groupContent='" + groupContent + '\'' +
				", groupCreateTime=" + groupCreateTime +
				", imgList=" + imgList +
				'}';
	}
}
