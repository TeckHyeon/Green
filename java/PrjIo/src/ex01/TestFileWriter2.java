package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter2 {

	public static void main(String[] args) throws IOException {
		String[] names = { "민지", "하니", "다니엘", "혜린", "혜인" };
		String path = "D:\\dev\\java\\PrjIo\\src\\ex01";
		String filenames = "data2.txt";
		FileWriter fw = new FileWriter(filenames);
		for (int i = 0; i < names.length; i++) {
			fw.write((i + 1) + "." + names[i] + "\n");
		}
		fw.close();
		System.out.println("파일 저장");
	}

}
