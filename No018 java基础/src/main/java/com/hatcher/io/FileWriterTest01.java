package com.hatcher.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description:
 */
public class FileWriterTest01 {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("E:\\code\\code-exercise-20\\ioTestFile", true);
			// 可以直接写字符串
			fileWriter.write("阿巴阿巴阿巴");
			// 也可以写入字符数组
			char[] chars = new char[]{'你', '好', '呀'};
			fileWriter.write(chars);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
