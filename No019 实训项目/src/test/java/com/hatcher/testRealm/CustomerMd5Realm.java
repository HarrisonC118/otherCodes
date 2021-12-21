package com.hatcher.testRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description: 自定义realm,让shiro使用MD5 + salt + hash 的方式加解密
 */
public class CustomerMd5Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if ("admin".equals(primaryPrincipal)) {
            simpleAuthorizationInfo.addRole("admin");
        }
        simpleAuthorizationInfo.addStringPermission("user:*:01");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String)token.getPrincipal();
        if ("admin".equals(principal)) {
            // 参数1：用户名 参数2：加密后的密码 参数3：这个密码的salt值 参数4：realm的名字
            return new SimpleAuthenticationInfo("admin",
                    "14b9f6ecccb925f15cf92c44ff9326ce",
                    ByteSource.Util.bytes("x0*7ps"),
                    getName());
        }
        return null;
    }
}
