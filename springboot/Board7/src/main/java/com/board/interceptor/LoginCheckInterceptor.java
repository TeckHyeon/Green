package com.board.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");

		String requestUrl = request.getRequestURL().toString();
		// 로그인 페이지는 체크에서 제외한다 (제외 설정)
	/*	if(requestUrl.contains("/login")) {
			return true; //로그인 체크를 중단
		}	
	*/		
		// ----------------------------------------------------
		
		if (obj == null) {
			System.out.println("====== 인터셉터 ======");
			System.out.println("비 로그인 상태 : ");
			response.sendRedirect(requestUrl);
			return false;
		} else {
			System.out.println("====== 인터셉터 ======");
			System.out.println("로그인 상태 : ");
			System.out.println(obj);
			return HandlerInterceptor.super.preHandle(request, response, handler);
		} 

	}
}