package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
public class QuizController3 {

	@GetMapping("/return/q1")
	public void q1() {
	}

	@GetMapping("/return/q2")
	public String q2() {
		return "return/test";
	}

	@ResponseBody
	@GetMapping("/return/q3")
	public StudentDTO q3() {
		StudentDTO dto = new StudentDTO(1, "둘리", 3);
		return dto;
	}

	@ResponseBody
	@GetMapping("/return/q4")
	public CarDTO q4() {
		CarDTO dto = new CarDTO("현대", "코나", "블랙");
		return dto;
	}

	@ResponseBody
	@GetMapping("/return/q5")
	public List<StudentDTO> q5() {
		List<StudentDTO> list = new ArrayList<>();
		list.add(new StudentDTO(1, "둘리", 3));
		list.add(new StudentDTO(2, "또치", 1));
		list.add(new StudentDTO(3, "도우너", 2));
		return list;
	}

	@ResponseBody
	@GetMapping("/return/q6")
	public ResponseEntity<String> q6() {
		return new ResponseEntity<>("response fail...", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseBody
	@GetMapping("/return/q7")
	public ResponseEntity<CarDTO> q7() {
		CarDTO dto = CarDTO.builder().company("현대").model("코나").color("블랙").build();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
