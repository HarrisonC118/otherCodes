package com.hatcher.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/17
 * @Description:
 */
public class TestMD5Hash {
    @Test
    public void testMd5() {
        // 使用Md5加密123并用十六进制的方式输出
        Md5Hash md5Hash = new Md5Hash("123456");
        System.out.println(md5Hash.toHex());

        // 使用Md5加salt的方式加密123
        Md5Hash md5Hash1 = new Md5Hash("123456","x0*7ps");
        System.out.println(md5Hash1.toHex());

        // 使用Md5加salt然后散列1024次的方式加密123
        Md5Hash md5Hash2 = new Md5Hash("123456","x0*7ps",1024);
        System.out.println(md5Hash2.toHex());
    }
}
