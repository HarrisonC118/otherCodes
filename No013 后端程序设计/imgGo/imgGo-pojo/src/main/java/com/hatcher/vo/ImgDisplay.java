package com.hatcher.vo;

import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/10/28
 */
public class ImgDisplay {
    private String userName;
    private List<GroupVo> groupList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<GroupVo> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupVo> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "ImgDisplay{" +
                "userName='" + userName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
