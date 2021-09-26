package com.hatcher;

import com.hatcher.api.HelloWorld;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: HatcherCheung
 * Date:  2021/9/25
 */
@SpringBootTest
public class YangchenTest {
    @Autowired
    private HelloWorld helloWorld;

    @Test
    public void a() {
        helloWorld.m();
    }
}
