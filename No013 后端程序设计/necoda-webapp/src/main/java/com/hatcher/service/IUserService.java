package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-08
 */
public interface IUserService extends IService<User> {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(String username, String password);

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     */
    int register(String username, String password);
}
