package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

	public static void main(String[] args) throws IOException {
		// data2.txt 를 읽어서 화면에 출력
		// BuffereadReader : 입력에 버퍼를 이용하여 속도를 증가 readLine()
		// BuufereadWriter : 출력에 버퍼를 이용하여 속도를 증가
		// ~Reader, ~Writer : 결과 String 으로 처리한다
		// InputStream, OutputStream : data를 byte로 처리 : binary
		String path = "D:\\dev\\java\\PrjIo\\src\\ex01";
		String filename = "data3.txt";
		FileReader fr = new FileReader(filename);
//		int ch;
//		while ((ch = fr.read()) != -1) {
//			System.out.print((char) ch);
//		}
//
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		//br,readLine()은 \n까지를 한줄로 보고 읽어온다
		//파일끝일때는 null을 return
//		Scanner scanner = new Scanner(fr);
//		while (scanner.hasNext()) {
//			String str = scanner.next();
//			System.out.println(str);
//		}
		fr.close();
	}

}
