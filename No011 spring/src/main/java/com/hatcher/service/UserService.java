package com.hatcher.service;

import com.hatcher.dao.UserDao;

/**
 * @author: HatcherCheung
 * Date:  2021/9/27
 */
public class UserService {
    private UserDao userDao;
    public void saveUser(String user) {
        userDao.saveUser(user);
        System.out.println("userService保存了");
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
