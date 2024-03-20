package ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

		
	public static void main(String[] args) {
		ServerSocket    serverSocket = null;
		// try catch 1.입출력 2.통신 3.변환(인코딩)
		try {
			serverSocket =  new ServerSocket();
			serverSocket.bind( new InetSocketAddress(5000) );  // 5000번 포트롤 통신
			
			while(true) {
				System.out.println("연결을 기다림");
				Socket             socket  =  serverSocket.accept();
				InetSocketAddress  isa     =  (InetSocketAddress) socket.getRemoteSocketAddress();
				isa.getHostName();
				System.out.println("[연결 수락됨]" 
							+ "   "
							+ isa.getAddress());
				
				// data 수신
				InputStream     is             =  socket.getInputStream();
				byte []         bytes          =  new byte[1024];
				
				int             readByteCount  =  is.read(bytes);
				// byte [] -> String
				String          msg            =  new String( bytes, 0, readByteCount, "UTF-8");
				System.out.println(msg);
				
				// data 송신
				OutputStream    os = socket.getOutputStream();
				msg                = "헬로 태훈이가 보냄";				
				
				// String  -> byte[];
				bytes       =   msg.getBytes("UTF-8");
				os.write( bytes);    // 클라이언트에 내보낸다
				os.flush();          // 버퍼에 남아있는 데이터를 전부 내보내어 clear 한다
				System.out.println("서버도 보낸다");
				
				is.close();
				os.close();
				socket.close();
			}		
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		// 서버 소켓 close
		if( !serverSocket.isClosed() ) {
			try {
				serverSocket.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}			
		}

	}

}









