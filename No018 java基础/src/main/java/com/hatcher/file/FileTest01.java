package com.hatcher.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/5
 * @Description:
 */
public class FileTest01 {
	public static void main(String[] args) {
		File file = new File("E:\\download\\download_baidu");
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println("当前File对象的名称：" + f.getName());
		}
		//	当前File对象的名称：1.邂逅Vue3和Vue3开发体验.mp4
		//	当前File对象的名称：1.邂逅Vue3和Vue3开发体验.rar
		//	当前File对象的名称：2.Vue3基础语法（⼀）.mp4
		//	当前File对象的名称：2.Vue3基础语法（⼀）.rar
		//	当前File对象的名称：3.Vue3基础语法（⼆）.rar
		//	当前File对象的名称：Vue3+TypeScript 前端进阶必修课
		//	当前File对象的名称：文档
		//	当前File对象的名称：课堂资料day01_44.rar

		// file.length() = 1788670152
		System.out.println("file.length() = " + file.length());


		long l = file.lastModified();
		Date time = new Date(l);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String format = simpleDateFormat.format(time);
		// 最后修改时间 = 2021-08-08 12-07-15
		System.out.println("最后修改时间 = " + format);
		// file.isFile() = true
		System.out.println("file.isFile() = " + file.isFile());
		// file.isDirectory() = false
		System.out.println("file.isDirectory() = " + file.isDirectory());
		// file.getName() = 2.Vue3基础语法（⼀）
		System.out.println("file.getName() = " + file.getName());
		// file.getParent() = E:\download\download_baidu
		System.out.println("file.getParent() = " + file.getParent());
		File parentFile = file.getParentFile();
		System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

	}
}
