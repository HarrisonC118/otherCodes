package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
    public boolean queryUsernameIsExist(String username);
}
