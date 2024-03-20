package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class Singer {
	private int num;
	private String name;
	private int age;

	@Override
	public String toString() {
		return "Singer [num=" + num + ", name=" + name + ", age=" + age + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

public class GetJson {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/data/data.json");
		BufferedReader br = new BufferedReader(fr);
		JsonElement jsonElement = JsonParser.parseReader(br);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		JsonArray jsonArray = jsonObject.getAsJsonArray("연예인들");

		// Gson 라이브러리를 사용하여 자바객체로 변환한다
		Gson gson = new Gson();
		Singer[] singers = gson.fromJson(jsonArray, Singer[].class);
		for (Singer singer : singers) {
			String fmt = "번호 : %d\n";
			fmt += "이름:%s\n";
			fmt += "나이:%d\n";
			String msg = String.format(fmt, singer.getNum(), singer.getName(), singer.getAge());
			System.out.println(msg);
		}
		br.close();
		fr.close();
	}

}
