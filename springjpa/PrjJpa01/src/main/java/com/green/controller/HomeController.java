package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/hi")
	public String hi() {
		return "greetings";
	}
	@GetMapping("/hi2")
	public String hi2(Model model) {
		model.addAttribute("name", "원영이");
		return "greetings2";
	}
	@GetMapping("/hi3")
	public String hi3(Model model) {
		model.addAttribute("username", "도현");
		return "greetings3";
	}
	@GetMapping("/hi4")
	public String hi4(Model model) {
		model.addAttribute("username", "도현");
		return "greetings4";
	}
	
}