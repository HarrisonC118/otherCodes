package com.hatcher.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description:
 */
public class FileInputStreamTest01 {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("E:\\code\\code-exercise-20\\ioTestFile");
			// 一次读一个字节
//			int readData = 0;
//			while ((readData = fileInputStream.read()) != -1) {
//				System.out.println(readData);
//			}
			// 一次读多个字节，最多读取数组.length个字节
			// 读取内容：abcdef
//			byte[] bytes = new byte[4];
//			int readCount = fileInputStream.read(bytes);
//			// 第一次读了：4
//			System.out.println("第一次读了：" + readCount);
//			readCount = fileInputStream.read(bytes);
//			// 第二次读了：2
//			System.out.println("第二次读了：" + readCount);
//			readCount = fileInputStream.read(bytes);
//			// 第三次读了：-1
//			System.out.println("第三次读了：" + readCount);

			byte[] bytes = new byte[4];
			int read = 0;
			while ((read = fileInputStream.read(bytes)) != -1) {
				// 把字节数组转化成字符串，第一个是要转换的数组，第二个是从哪开始，第三个是要转换的长度
				System.out.print(new String(bytes, 0, read));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream == null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
