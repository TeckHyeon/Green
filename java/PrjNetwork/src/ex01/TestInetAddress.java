package ex01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

	public static void main(String[] args) {
		InetAddress   local  = null; // ip 주소 class
		
		try {
			// ipconfig
			local = InetAddress.getLocalHost();
			System.out.println("내 아이피 주소:" + local.getHostAddress());
			
			System.out.println("네이버의 ip 주소목록");
		    InetAddress [] ia = InetAddress.getAllByName("naver.com");
		    for (InetAddress inetAddress : ia) {
				System.out.println(inetAddress);
			}
		    
		    System.out.println("구글의 ip 주소목록");
		    InetAddress [] ia2 = InetAddress.getAllByName("google.com");
		    for (InetAddress inetAddress : ia2) {
		    	System.out.println(inetAddress);
		    }
		    
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		}

	}

}








