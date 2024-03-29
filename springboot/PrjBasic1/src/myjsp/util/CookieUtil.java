package myjsp.util;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

public class CookieUtil {
	private HashMap<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	static sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	static sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	
	// 생성자
	// 해당 도메인의 모든 쿠키정보를 가져와서 HashMap 에 저장
	public CookieUtil(HttpServletRequest request) throws IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i=0; i<cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	// createCookie Method - 쿠키를 추가
	// 임시 쿠키    -  하드디스크에 저장되지 않음
	public static Cookie createCookie(String name, String value) throws IOException{
		return new Cookie(name, encoder.encode(value.getBytes()));
	}
	// 기간 있는 쿠키 -  하드디스크에 저장
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, encoder.encode(value.getBytes()));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, encoder.encode(value.getBytes()));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	// getCookie method
	public Cookie getCookie(String name) {
		return (Cookie)cookieMap.get(name);
	}
	
	// getValue method
	public String getValue(String name) throws IOException {
		Cookie cookie = (Cookie)cookieMap.get(name);
		if (cookie == null) {
			return null;
		} else {
			byte[] b = decoder.decodeBuffer(cookie.getValue());
			return new String(b);
		}
	}
	
	// exists method
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
}