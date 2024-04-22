package com.green.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.dto.UserDto;

// 이 페이지는 전부 @ResponseBody로 작동
@RestController
public class DataServerController {

	@RequestMapping("/ajax3")
	public String ajax3() {
		String userName = "카리나";
		return userName;
	}
	@RequestMapping("/ajax4")
	public UserDto ajax4() {
		String userid = "user";
		String userpass = "1234";
		String username = "카리나";
		UserDto user = new UserDto(userid, userpass, username);
		return user;
	}

}
