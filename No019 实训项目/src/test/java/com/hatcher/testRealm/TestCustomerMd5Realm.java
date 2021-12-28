package com.hatcher.testRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Arrays;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description: 测试使用了MD5加密的自定义realm
 */
public class TestCustomerMd5Realm {
    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();
        customerMd5Realm.setCredentialsMatcher(hashedCredentialsMatcher);
        // 开启权限管理
        // 设置缓存管理器
        customerMd5Realm.setCacheManager(new EhCacheManager());
        // 开启缓存
        customerMd5Realm.setCachingEnabled(true);
        // 开启认证缓存
        customerMd5Realm.setAuthenticationCachingEnabled(true);
        // 开启授权缓存
        customerMd5Realm.setAuthorizationCachingEnabled(true);
        // 设置认证缓存的名字
        customerMd5Realm.setAuthenticationCacheName("authenticationCache");
        // 设置授权缓存的名字
        customerMd5Realm.setAuthorizationCacheName("authorizationCache");

        defaultSecurityManager.setRealm(customerMd5Realm);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","123456");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功！");
            System.out.println("subject.hasRole(\"admin\") = " + subject.hasRole("admin"));
            System.out.println("subject.hasAllRoles(Arrays.asList(\"admin\", \"super\")) = " + subject.hasAllRoles(Arrays.asList("admin", "super")));
            System.out.println("subject.hasRoles(Arrays.asList(\"admin\",\"super\")) = " + Arrays.toString(subject.hasRoles(Arrays.asList("admin", "super"))));

        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名未找到！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("账号密码错误！");
        }
    }
}
