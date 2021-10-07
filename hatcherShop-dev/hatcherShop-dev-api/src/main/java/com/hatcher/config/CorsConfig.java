package com.hatcher.config;
/**
 * 设置跨域请求的控制类
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * @author: HatcherCheung
 * Date:  2021/10/7
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");
        // 2. 设置是否可以发送cookie信息
        config.setAllowCredentials(true);
        // 3. 设置允许请求的方法，默认只允许GET和HEAD
        config.setAllowedMethods(Collections.singletonList("*"));
        // 4. 设置允许请求的header
        config.setAllowedHeaders(Collections.singletonList("*"));
        // 5. 让所有url都执行这个过滤器
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(corsSource);
    }
}
