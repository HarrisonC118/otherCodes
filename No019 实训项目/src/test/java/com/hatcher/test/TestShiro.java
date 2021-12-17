package com.hatcher.test;

import com.mysql.cj.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/14
 * @Description:
 */

public class TestShiro {
	@Test
	public void test01() {
		// 1. 创建安全管理器对象
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		// 2. 以后都会使用Security的工具类去做权限的认证
		// 告诉工具类是要使用哪个安全管理器
		SecurityUtils.setSecurityManager(securityManager);
		// 3. 创建realms，设置存在的账号和密码(读取shiro配置文件中的数据)
		Realm realm = new IniRealm("classpath:shiro.ini");
		securityManager.setRealm(realm);
		// 4. 因为shiro中要通过subject来做认证,所以要有主体的对象,在工具类中获取
		Subject subject = SecurityUtils.getSubject();
		// 5. 创建由用户名和密码组成的token令牌，用来做验证
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack","111");
		// 如果登录成功，就什么都没有，如果登录失败，就会抛出一个异常
		try{
			// 获取是否通过验证
			System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
			subject.login(usernamePasswordToken);
			System.out.println("subject.isAuthenticated() = " + subject.isAuthenticated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
