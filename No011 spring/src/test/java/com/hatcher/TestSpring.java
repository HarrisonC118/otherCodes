package com.hatcher;

import com.hatcher.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: HatcherCheung
 * Date:  2021/10/1
 */
public class TestSpring {
    @Test
    public void startSpring() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("./applicationContext.xml");
        User user = (User)classPathXmlApplicationContext.getBean("userBean");
        System.out.println("user = " + user);
    }
}
