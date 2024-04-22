package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcController {
	
	@GetMapping("/")
	public String main() {

		return "index";
	}
	@GetMapping("/Mvc")
	public String mvcMain(Model model) {
		String userName = "카리나";
		model.addAttribute("userName", userName);
		return "mvc";
	}
	@GetMapping("/ajax1")
	public String ajax1() {
		String userName = "카리나";
		return userName;
	}
	@GetMapping("/ajax2")
	@ResponseBody
	public String ajax2() {
		String userName = "카리나";
		return userName;
	}
}
