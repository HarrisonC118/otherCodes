package com.hatcher.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/4
 * @Description: 自带缓冲区的字符输入流
 */
public class BufferedReaderTest01 {
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader("E:\\code\\code-exercise-20\\No018 java基础\\src\\main\\java\\com\\hatcher\\io\\BufferedReaderTest01.java");
			bufferedReader = new BufferedReader(fileReader);
			String info = "";
			while ((info = bufferedReader.readLine()) != null) {
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
