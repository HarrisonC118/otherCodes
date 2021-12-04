package com.hatcher.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description: 字节输出流 负责写的
 */
public class FileOutputStreamTest01 {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		try {
			// 如果文件不存在，则会创建一个文件
			fileOutputStream = new FileOutputStream("E:\\code\\code-exercise-20\\ioTestFile", true);
			// ascii码对应的值为a,b,c,d
			byte[] bytes = new byte[]{97, 98, 99, 100};
			// 从数组中的1号元素开始，写两个字节大小的文件
			fileOutputStream.write(bytes, 1, 2);
			// 写出了b,c
			// 刷新
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
