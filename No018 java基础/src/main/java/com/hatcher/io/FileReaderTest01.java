package com.hatcher.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description:
 */
public class FileReaderTest01 {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("E:\\code\\code-exercise-20\\ioTestFile");
			// 因为fileReader是以字符为单位的，所以要用char数组
			char[] chars = new char[4];
			int read = 0;
			while ((read = fileReader.read(chars)) != -1) {
				System.out.print(new String(chars, 0, read));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
