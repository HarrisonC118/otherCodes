package com.hatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

/**
 * @author: HatcherCheung
 * @Date: 2021/11/15
 * @Description: 启动类
 */

@SpringBootApplication
@EnableJdbcRepositories("com.hatcher.dao.") //这里的扫描目录要写好了
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class);
	}
}
