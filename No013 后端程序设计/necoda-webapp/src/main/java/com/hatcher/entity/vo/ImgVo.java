package com.hatcher.entity.vo;

import java.time.LocalDateTime;

/**
 * @author: HatcherCheung
 * Date:  2021/10/28
 */
public class ImgVo {
    private String imgId;
    private String imgMasterName;
    private String imgUrl;
    private LocalDateTime imgCreateTime;

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgMasterName() {
        return imgMasterName;
    }

    public void setImgMasterName(String imgMasterName) {
        this.imgMasterName = imgMasterName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getImgCreateTime() {
        return imgCreateTime;
    }

    public void setImgCreateTime(LocalDateTime imgCreateTime) {
        this.imgCreateTime = imgCreateTime;
    }

    @Override
    public String toString() {
        return "ImgVo{" +
                "imgId='" + imgId + '\'' +
                ", imgMasterName='" + imgMasterName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgCreateTime=" + imgCreateTime +
                '}';
    }
}
