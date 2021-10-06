package com.hatcher.aop;

/**
 * @author: HatcherCheung
 * Date:  2021/10/2
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService = new UserServiceImpl();
    @Override
    public boolean login() {
        System.out.println("日志：登录执行了");
        return userService.login();
    }
}
