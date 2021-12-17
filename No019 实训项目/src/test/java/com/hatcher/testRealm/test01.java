package com.hatcher.testRealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description:
 */
public class test01 extends AuthorizingRealm {

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取token中的用户名
		String username = (String)token.getPrincipal();
		if ("admin".equals(username)) {
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("admin","123456",getName());
			return (simpleAuthenticationInfo);
		}
		return null;
	}
}
