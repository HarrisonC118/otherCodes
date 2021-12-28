package hatcher.util;

import java.util.Random;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/24
 * @Description: 随机盐生成工具类
 */
public class SaltUtils {
    /**
     * 生成salt
     * @param n 生成n位数的随机salt
     * @return 生成的n为随机salt
     */
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789~!@#$%^&*()_+|}{';/.,<>?:=-`".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
