package com.board.user.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/List")
	public ModelAndView list(Model model) {
		List<UserVo> lists = userMapper.viewUser();
		ModelAndView mv = new ModelAndView();
		mv.addObject("lists", lists);
		mv.setViewName("users/list");
		return mv;
	}

	@RequestMapping("/signinForm")
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
		mv.setViewName("redirect:/Users/List");
		return mv;
	}

	@RequestMapping("/Delete")
	public ModelAndView Delete(@RequestParam("userid") String userid, UserVo userVo) {
		userVo.setUserid(userid);
		userMapper.DeleteUser(userVo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Users/List");
		return mv;
	}

	@RequestMapping("/UpdateForm/{userid}")
	public ModelAndView UpdateForm(@PathVariable("userid") String userid, UserVo userVo) {
		ModelAndView mv = new ModelAndView();
		userVo = userMapper.userDetail(userid);
		mv.addObject("user", userVo);
		mv.setViewName("users/UpdateForm");
		return mv;
	}

	@RequestMapping("/Update/{userid}")
	public String Update(@PathVariable("userid") String userid, UserVo userVo) {
		userVo.setUserid(userid);
		userMapper.updateUser(userVo);
		return "redirect:/Users/List";
	}
}
