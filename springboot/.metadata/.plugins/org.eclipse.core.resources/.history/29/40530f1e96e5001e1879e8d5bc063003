package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	// http://localhost:9090/	
	@RequestMapping("/")
	public  String  home() {
		return  "home";    //  "/WEB-INF/views/" + "home" + ".jsp"
	}
	
	// http://localhost/test
	@RequestMapping("/test")
	@ResponseBody
	public  String  test() {
		return  "<h2>Test 입니다</h2>"; 
		  //  //  "/WEB-INF/views/" + "<h2>Test 입니다</h2>" + ".jsp"
	}

}







