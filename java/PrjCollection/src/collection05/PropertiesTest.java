package collection05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = null;
		// String path =
		// "D:\\dev\\java\\PrjCollection\\src\\collection05\\database.properties"; //
		// path : 경로 + 파일명
		String path = "D:/dev/java/PrjCollection/bin/collection05/database.properties"; // path : 경로 + 파일명
		// String path = PropertiesTest.class.getResource("database.properties").getPath();

		// 현재 실행중인 class 의 folder 위치를 반환한다

		// /D:/dev/java/PrjCollection/bin/collection05/database.properties

		System.out.println(path);
		prop = new Properties();

		prop.load(new FileReader(path));

		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

	}

}
