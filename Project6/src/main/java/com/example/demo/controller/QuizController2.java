package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")
public class QuizController2 {
	
	@ResponseBody
	@GetMapping("/q1")
	public String q1(@RequestParam(name="i") String i) {
		System.out.println("String 타입 파라미터 수집:"+i);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q2")
	public String q2(@RequestParam(name="f") float f, @RequestParam(name="b") boolean b ) {
		System.out.println("float 타입 파라미터 수집:"+ f + " boolean타입 파라미터 수집:" + b);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public String q3(@RequestParam(name = "arr") char[] arr ) {
		System.out.println("arr형 배열 수집:"+ Arrays.toString(arr));
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("배열의 개수 :"+ arr.length);
		return "ok";
	}
	
	//4,5,6번: 복잡한 파라미터는 메세지 바디에 데이터를 담을 것
	//@RequestBody 사용하여 JSON형식의 문자열 클래스로 반환
	
	@ResponseBody
	@PostMapping("/q4")
	public String q4(@ModelAttribute StudentDTO dto) {
		System.out.println("객체 수집:" + dto);
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q5")
	public String q5(@RequestBody ArrayList<StudentDTO> list) {
		System.out.println("객체타입 리스트 수집:" + list);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println("리스트 개수:"+list.size());
		return "ok";
	}
	
	@ResponseBody
	@PostMapping("/q6")
	public String q6(@RequestBody ArrayList<CarDTO> list) {
		System.out.println("객체타입 리스트 수집:" + list);
		for(CarDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("리스트 마지막 요소:"+ list.get(list.size()-1));
		return "ok";
	}
	
}
