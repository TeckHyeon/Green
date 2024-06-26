package com.kdh.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if ((String)session.getAttribute("userId") == null) {
			System.out.println("====== interceptor ======");
			System.out.println("비 로그인 상태 : ");
			System.out.println((String)session.getAttribute("userId"));
			
			response.sendRedirect("/login");
			return false;
		}
		else {
			System.out.println("====== interceptor ======");
			System.out.println("로그인 상태 : ");
			System.out.println((String)session.getAttribute("userId"));
			
			session.setMaxInactiveInterval(1800);
			return true;
		}
	}
}