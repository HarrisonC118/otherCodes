package hatcher.config;

import hatcher.shiro.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/21
 * @Description: shiro的配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 1. 创建shiroFilter
     * 需要使用安全管理器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        // 工厂会自动调用getDefaultWebSecurityManager方法来获取值
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        // 配置受限资源和公共资源
        Map<String,String> map = new HashMap<String,String>();
        // authc: 这个资源需要认证和授权才能访问
        map.put("/index.jsp","authc");
        // 设置默认的认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
    /**
     * 2. 创建安全管理器
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }
    /**
     * 3. 创建自定义realm
     */
    @Bean
    public Realm getRealm() {
        return new CustomerRealm();
    }
}
