package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.bo.UserBO;
import com.hatcher.entity.Users;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface IUsersService extends IService<Users> {
    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 存在返回true, 不存在返回false
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     *
     * @param userBO 要创建的对象
     * @return 创建完的对象
     */
    Users createUser(UserBO userBO);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功的对象
     */
    Users queryUserForLogin(String username, String password);
}
