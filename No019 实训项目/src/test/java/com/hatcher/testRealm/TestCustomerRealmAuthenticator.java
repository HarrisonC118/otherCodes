package com.hatcher.testRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description: 用来测试自定义的realm
 */
public class TestCustomerRealmAuthenticator {
	public static void main(String[] args) {
		// 创建securityManager
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		// 配置自定义的realm
		securityManager.setRealm(new test01());
		// 设置安全工具类
		SecurityUtils.setSecurityManager(securityManager);
		// 通过安全工具类获取subject
		Subject subject = SecurityUtils.getSubject();
		// 创建token
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");

		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
}
