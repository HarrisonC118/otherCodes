package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@ApiModel(value = "Users对象", description = "用户表 ")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id 用户id")
    @TableField
    private String id;

    @ApiModelProperty("用户名 用户名")
    private String username;

    @ApiModelProperty("密码 密码")
    private String password;

    @ApiModelProperty("昵称 昵称")
    private String nickname;

    @ApiModelProperty("真实姓名")
    private String realname;

    @ApiModelProperty("头像")
    private String face;

    @ApiModelProperty("手机号 手机号")
    private String mobile;

    @ApiModelProperty("邮箱地址 邮箱地址")
    private String email;

    @ApiModelProperty("性别 性别 1:男  0:女  2:保密")
    private Integer sex;

    @ApiModelProperty("生日 生日")
    private LocalDate birthday;

    @ApiModelProperty("创建时间 创建时间")
    private LocalDateTime createdTime;

    @ApiModelProperty("更新时间 更新时间")
    private LocalDateTime updatedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
        return "Users{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", nickname=" + nickname +
                ", realname=" + realname +
                ", face=" + face +
                ", mobile=" + mobile +
                ", email=" + email +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                "}";
    }
}
