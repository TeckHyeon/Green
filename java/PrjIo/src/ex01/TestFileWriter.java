package ex01;

import java.io.FileWriter;

public class TestFileWriter {

	public static void main(String[] args) {
		// 새파일 생성
		// 경로 : Path + 파일명(Filename)
		String filename = "data.txt";
		// 현재경로 : Current Path = 실행하는 .class 가 있는 곳
		// 현재 프로젝트의 최상단에 저장된다.

		try {
			FileWriter fw = new FileWriter(filename);
			fw.write("A");
			fw.write(66); //B
			fw.write(48); // 0
			fw.write(97); // a
			fw.write(10); // '\n
			fw.write("태훈이");
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("파일이 저장되었습니다");
	}

}
