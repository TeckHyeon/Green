package ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestClient {

	public static void main(String[] args) {
		Socket   socket  =  null;
		try {
			socket           =  new  Socket();
			System.out.println("[서버에 연결 요청]");
			
			InetSocketAddress    isa = new InetSocketAddress("192.168.0.212", 5000 );
			socket.connect(isa);
			System.out.println("[서버에 연결 성공]");
			
			// 서버에 data 보내기
			byte []  bytes = null;			
			OutputStream   os  =  socket.getOutputStream();
			String         msg =  "서버야 받아라!!!!";
			bytes              = msg.getBytes();
			os.write(bytes);
			os.flush();
			System.out.println("[데이터를 서버에 보냈습니다]");
			
			// 서버에서 data 받기
			InputStream     is              =  socket.getInputStream();
			bytes                           =  new byte[1024];
			int             readBytesCount  =  is.read(bytes); 
			msg                             =  new String(bytes, 0, readBytesCount, "UTF-8"); //byte 배열을 String으로 바꿈
			System.out.println("서버가 보낸거:" + msg);
			
			is.close();
			os.close();
			socket.close();					
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}











