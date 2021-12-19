package com.hatcher.testRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description: 测试使用了MD5加密的自定义realm
 */
public class TestCustomerMd5Realm {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();
        // 自定义凭证匹配器
        // 默认的凭证匹配器是equals方法，我们可以通过setCredentialsMatcher方法配置自己的凭证匹配器
        // MD5的凭证匹配器的名字是HashedCredentialsMatcher，还要设置算法的名字是md5
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 设置散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        // 把自定义的凭证匹配器配置到自定义的realm中
        customerMd5Realm.setCredentialsMatcher(hashedCredentialsMatcher);
        securityManager.setRealm(customerMd5Realm);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","123456");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功！");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在！");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("账号密码错误！");
        }
    }
}
