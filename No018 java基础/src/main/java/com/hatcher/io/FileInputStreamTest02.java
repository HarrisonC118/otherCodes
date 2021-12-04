package com.hatcher.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description:
 */
public class FileInputStreamTest02 {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("E:\\code\\code-exercise-20\\ioTestFile");

//			// 读取内容：abcdef 一共六个字节
//			// 读一个字节
//			fileInputStream.read();
//			// 还剩下5个字节没读
//			System.out.println("还剩下" + fileInputStream.available() + "个字节没读");

			// 读取内容: abcdef
			// 跳过第一个字节的内容
			fileInputStream.skip(1);
			byte[] bytes = new byte[4];
			// 从流中读出四个字节的数据存到字节数组中
			int read = fileInputStream.read(bytes);
			// bcde
			System.out.println(new String(bytes, 0, read));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
