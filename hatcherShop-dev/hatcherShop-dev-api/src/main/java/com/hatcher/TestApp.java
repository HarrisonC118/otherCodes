package com.hatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: HatcherCheung
 * Date:  2021/9/17
 */
@SpringBootApplication
@MapperScan("com.hatcher.mapper")
public class TestApp {
    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }

}
