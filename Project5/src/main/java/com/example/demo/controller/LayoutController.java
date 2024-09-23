package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {
	@GetMapping("/exLayout1")
	public void ex1() { 
		// 리턴타입이 void면 url경로가 html 파일의 경로가 된다
	}
}
