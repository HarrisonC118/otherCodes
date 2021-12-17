package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.bo.UserLoginBo;
import com.hatcher.bo.UserRegisterBo;
import com.hatcher.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-08
 */
public interface IUserService extends IService<User> {
	/**
	 * 用户登录
	 *
	 * @param user 用户名 密码 的对象
	 * @return 登录成功是用户对象，登录失败是null
	 */
	User login(UserLoginBo user);

	/**
	 * 用户注册
	 *
	 * @param user 用户名 密码 的对象
	 * @return 1：注册成功
	 */
	int register(UserRegisterBo user);

	/**
	 * 判断用户id是否存在
	 *
	 * @param userId 用户id
	 * @return true: 存在 false: 不存在
	 */
	boolean isIdExist(String userId);

	/**
	 * 判断用户名是否存在
	 *
	 * @param username 用户名
	 * @return true/false
	 */
	boolean isUsernameExist(String username);

	/**
	 * 根据用户名获取用户Id
	 *
	 * @param username 用户名
	 * @return 用户Id
	 */
	String getIdByUsername(String username);
}
