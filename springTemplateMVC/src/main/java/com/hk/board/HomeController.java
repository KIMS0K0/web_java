package com.hk.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home() {
		System.out.println("HOME 페이지 요청함");
		return "home";
	}
}
