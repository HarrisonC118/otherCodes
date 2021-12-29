package hatcher;

import hatcher.util.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/21
 * @Description:
 */

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        RedisTemplate bean = run.getBean("redisTemplate",RedisTemplate.class);
        bean.opsForValue().set("hatcher","yc");
    }

}
