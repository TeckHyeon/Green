package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class Food {
	private String name;
	private String loc;
	private String locDet;
	private String pnumber;
	private String fkind;
	private String menu;
	
	public String getName() {
		return name;
	}

	public String getLocDet() {
		return locDet;
	}

	public void setLocDet(String locDet) {
		this.locDet = locDet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getFkind() {
		return fkind;
	}

	public void setFkind(String fkind) {
		this.fkind = fkind;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Food() {
		
	}
}

public class TestFoodList {
	private static ArrayList<Food> foodList;
	public static void main(String[] args) throws IOException {
		
		foodList = new ArrayList<>();
		
		String path = "D:\\dev\\java\\PrjIo\\src\\ex04\\";
		String filename = path + "부산광역시_수영구_모범음식점 현황_20240108.CSV";
//		FileReader fr = new FileReader(filename);
//		BufferedReader br = new BufferedReader(fr);
		String line = "";
//		while ((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
//		br.close();
//		fr.close();
		FileReader fr2 = new FileReader(filename);
		BufferedReader br2 = new BufferedReader(fr2);
		// 검색 기능 : 음식의유형
		// 검색어 키보드 입력받아 파일에 있는 정보를 출력
		Scanner in = new Scanner(System.in);
		System.out.println("\n 검색어를 입력해주세요");
		String sText = in.nextLine().trim();
		line = "";
		while ((line = br2.readLine()) != null) {
			if (line.contains(sText)) {
				String[] li = line.split(",");
				String name = li[0];
				String loc = li[1];
				String locDet = li[2];
				String pnumber = li[3];
				String fkind = li[4];
				String menu = li[5];
				Food food = new Food();
				
				food.setName(name);
				food.setLoc(loc);
				food.setLocDet(locDet);
				food.setPnumber(pnumber);
				food.setFkind(fkind);
				food.setMenu(menu);
				foodList.add(food);
				String title = "검색결과\n";
				String msg = title;
				String fmt = "업소명 : %4s\n소재지 : %4s%2s\n전화번호 : %4s\n주된음식 : %4s\n\n";
				for (Food f : foodList) {
					msg += String.format(fmt, f.getName(), f.getLoc(),f.getLocDet(), f.getPnumber(), f.getMenu());
					// System.out.println(empList.get(i));
				}
				System.out.println(msg);
			}
			
			
		}
		br2.close();
		fr2.close();	
	}

}
