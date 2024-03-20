package ex05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestPost {

	public static void main(String[] args) throws IOException {
		String path = "D:\\dev\\java\\PrjIo\\src\\ex05\\";
		String filename = path + "zipcode_20130201.csv";
		File infile = new File(filename);
		if (!infile.exists()) {
			System.out.println("파일이 존재하지 않습니다");
			System.exit(-1);
		}
		FileReader fr = new FileReader(infile);
		BufferedReader br = new BufferedReader(fr);
		//1,전국 롯데백화점
		String dong = "롯데백화점";
		//2. 부산의 우편번호
		//3.부전2동의 우편번호
		//4.부산 우편번호의 개수
		//5.전국 시도의 개수
		//6. 시도별 우편번호의 개수
		int cnt = 0;		
		br.readLine();
		String line = "";
		while( (line = br.readLine() ) != null ) {
			// 입력
			Post  post = new Post(line);
			if (post.getDong().contains(dong)) {
				System.out.println(post);
				cnt++;
			}
		/*	
			String  msg = "";
			String  fmt =  "SEQ	: %s\n";
			fmt        +=  "시     : %s\n";
			fmt        +=  "군/구     : %s\n";
			fmt        +=  "동   : %s\n";
			fmt        +=  "번지 : %s\n";
			fmt        +=  "우편번호   : %s\n";
			if(line.contains(dong)) {
				
				
				msg = String.format(fmt,
						post.getSeq(),
						post.getSido(),
						post.getGugun(),
						post.getDong(),
						post.getBunji(),
						post.getZipcode());
				System.out.println(msg);
			} */
		}
		
	/*	Scanner in = new Scanner(System.in);
		System.out.println("검색하실 주소를 입력해주세요.");
		String sText = in.nextLine().trim(); 
		br.readLine(); */	      
		br.close();
		fr.close();
		System.out.println(dong + "이 " + cnt + "건 출력되었습니다.");
	}

}
