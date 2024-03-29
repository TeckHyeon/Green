package com.board.user.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserMapper userMapper;

	// /Users/List
	@RequestMapping("/list")
	public ModelAndView list() {
		// 목록 조회
		List<UserVo> userList = userMapper.getUserList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("users/list");

		return mv;
	}

	// /Users/WriteForm
	@RequestMapping("/writeForm")
	public ModelAndView writeForm() {

		ModelAndView mv = new ModelAndView();
		LocalDateTime today = LocalDateTime.now();
		String now = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSSS"));
		DayOfWeek wkday = today.getDayOfWeek();
		now += " " + wkday;
		mv.addObject("now", now);
		mv.setViewName("users/write");
		return mv;

	}

	// /Users/Write
	@RequestMapping("/write")
	public ModelAndView write(UserVo userVo) {
		System.out.println();
		// 저장
		userMapper.insertUser(userVo);

		// 데이터를 가지고 이동한다
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/list");
		return mv;
	}

	@RequestMapping("/view")
	public ModelAndView view(UserVo userVo) {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> map = userMapper.getUserView(userVo);
		log.info("vo = {}", map);
		mv.addObject("vo", map);
		mv.setViewName("users/view");
		return mv;
	}

	@RequestMapping("/signinform")
	public ModelAndView signin() throws Exception {
		ModelAndView mv = new ModelAndView();
		LocalDateTime today = LocalDateTime.now();
		String now = today.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:SS"));
		DayOfWeek wkday = today.getDayOfWeek();
		now += " " + wkday;
		mv.addObject("now", now);
		mv.setViewName("users/signin");

		return mv;
	}

	@RequestMapping("/signin")
	public ModelAndView signin(UserVo userVo) throws Exception {
		userMapper.signinUser(userVo);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/list");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(UserVo userVo) {
		userMapper.DeleteUser(userVo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/list");
		return mv;
	}

	@RequestMapping("/updateform")
	public ModelAndView updateForm(UserVo userVo) {
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> map = userMapper.userUpdate(userVo);
		mv.addObject("vo", map);
		log.info("vo = {}", map);
		mv.setViewName("users/updateform");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(UserVo userVo) {
		userMapper.updateUser(userVo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/list");
		return mv;
	}


}
