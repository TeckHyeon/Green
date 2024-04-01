package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;
import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;

	// http://localhost:9090
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/loginform")
	public ModelAndView loginform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users/login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(UserVo userVo, HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		userVo = userMapper.login(userid, passwd);
		MenuVo menuVo = menuMapper.getMenu("MENU01");
		ModelAndView mv = new ModelAndView();
		String loc = "";
		if (userVo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", userVo);
			session.setAttribute("menu", menuVo);
			session.setMaxInactiveInterval(30 * 60);
			loc = "redirect:/";
			mv.setViewName(loc);
		} else {
			loc = "redirect:/loginform";
			mv.setViewName(loc);
		}

		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {

		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/loginform");
		return mv;
	}

}
