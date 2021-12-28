package com.hatcher.test;

import hatcher.util.SaltUtils;
import org.junit.Test;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/24
 * @Description:
 */
public class TestWhat {
    @Test
    public void test01 () {
        int a = 10;
        a = a++;
        System.out.println(a);
    }
    @Test
    public void testSaltUtils() {
        String salt = SaltUtils.getSalt(12);
        System.out.println(salt);
    }
}
