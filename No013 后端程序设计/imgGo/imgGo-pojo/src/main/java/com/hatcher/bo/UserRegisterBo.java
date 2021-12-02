package com.hatcher.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author: HatcherCheung
 * @Date: 2021/11/15
 * @Description:
 */
@ApiModel(value = "用户注册时的对象")
public class UserRegisterBo {
	@ApiModelProperty("用户名")
	private String username;
	@ApiModelProperty("密码")
	private String password;

	public UserRegisterBo(String username, String password) {
		this.username = username;
		this.password = password;
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
}
