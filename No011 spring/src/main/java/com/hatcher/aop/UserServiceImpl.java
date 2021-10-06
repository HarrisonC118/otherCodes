package com.hatcher.aop;

/**
 * @author: HatcherCheung
 * Date:  2021/10/2
 */
public class UserServiceImpl implements UserService{
    @Override
    public boolean login() {
        System.out.println("登陆成功了了");
        return true;
    }
}
