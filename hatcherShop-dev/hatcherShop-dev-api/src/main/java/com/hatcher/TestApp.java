package com.hatcher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
