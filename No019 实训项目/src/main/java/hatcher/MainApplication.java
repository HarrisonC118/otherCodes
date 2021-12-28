package hatcher;

import hatcher.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/21
 * @Description:
 */

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        RedisUtil redisUtil = (RedisUtil) run.getBean("redisUtil");
        redisUtil.set("hello","hatcher");
    }
}
