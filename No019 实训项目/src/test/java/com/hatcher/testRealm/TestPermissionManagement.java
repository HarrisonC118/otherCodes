package com.hatcher.testRealm;

import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.aop.scope.ScopedProxyUtils;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/21
 * @Description: 测试权限
 */
public class TestPermissionManagement {
    @Test
    public void testPermission() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        CustomerMd5Realm myRealm = new CustomerMd5Realm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashIterations(1024);
        hashedCredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        defaultSecurityManager.setRealm(myRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin", "123456");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            System.out.println(subject.getPrincipal() + "登录成功！");
            System.out.println("===========================================");
            // 开始授权测试
            boolean[] permitteds = subject.isPermitted("user:*:01", "order:*:02");
            for (boolean permitted : permitteds) {
                System.out.println(permitted);
//                if (permitted) {
//                    System.out.println("用户权限认证通过！");
//                } else {
//                    System.out.println("用户权限认证失败!");
//                }
            }
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户名密码错误！");
            e.printStackTrace();
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名未找到！");
        }
    }
}
