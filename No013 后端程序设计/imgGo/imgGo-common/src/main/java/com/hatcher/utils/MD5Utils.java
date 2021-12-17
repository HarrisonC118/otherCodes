package com.hatcher.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * @author hatcherCheung
 */
public class MD5Utils {
	/**
	 * @Title: MD5Utils.java
	 * @Package com.hatcher
	 * @Description: 对字符串进行md5加密
	 */
	public static String getMD5Str(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return Base64.encodeBase64String(md5.digest(strValue.getBytes()));
	}
}
// hutools