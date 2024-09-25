package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/method/q")
public class QuizController1 {
	@ResponseBody
	@GetMapping
	public String getmethod() {
		System.out.println("조회");
		return "ok";
	}
	
	@ResponseBody
	@PostMapping
	public String postmethod() {
		System.out.println("등록");
		return "ok";
	}
	
	@ResponseBody
	@PutMapping
	public String putmethod() {
		System.out.println("수정");
		return "ok";
	}
	
	@ResponseBody
	@DeleteMapping
	public String deletemethod() {
		System.out.println("삭제");
		return "ok";
	}
}
