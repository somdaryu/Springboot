package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	//model:뷰에 데이터를 전달하는 객체
	//void: URL 경로에따라 HTML 파일 반환
	@GetMapping("/q1")
	public void quiz1(Model model) {
		model.addAttribute("name", "둘리");
		model.addAttribute("age", "20");
		model.addAttribute("address", "인천 구월동");
	}
	
	@GetMapping("/q2")
	public void quiz2(Model model) {
		model.addAttribute("title", "스프링부트웹프로젝트");
		model.addAttribute("author", "구멍가게 코딩단");
		model.addAttribute("publish", LocalDate.of(2022, 12, 25));
	}
	
	@GetMapping("/q3")
	public void quiz3(Model model) {
		PersonDTO personDTO = PersonDTO.builder()
										.name("둘리")
										.age(20)
										.address("인천 구월동")
										.build();
		model.addAttribute("dto", personDTO);
	}
	
	@GetMapping("/q4")
	public void quiz4(Model model) {
		BookDTO bookDTO = BookDTO.builder()
								.title("스프링부트웹프로젝트")
								.author("구멍가게 코딩단")
								.publicationDate(LocalDate.of(2022, 12, 25))
								.build();
		
		model.addAttribute("dto", bookDTO);
	}
	
	@GetMapping("/q5")
	public void quiz5(Model model) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		model.addAttribute("arr", arr);
	}
	
	@GetMapping("/q6")
	public void quiz6(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		
		list.add(new PersonDTO("둘리", 20, "인천 구월동"));
		list.add(new PersonDTO("또치", 20, "서울 신림동"));
		list.add(new PersonDTO("도우너", 20, "부산 문래동"));
		
		model.addAttribute("list", list);
	}
	
	@GetMapping("/q7")
	public void quiz7(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		
		list.add(new PersonDTO("둘리", 20, "인천 구월동"));
		list.add(new PersonDTO("또치", 30, "서울 신림동"));
		list.add(new PersonDTO("도우너", 40, "부산 문래동"));
		
		model.addAttribute("list", list);
	}
	
	@GetMapping({"/q8", "/q9"})
	public void quiz8(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("박하나", 25, "인천 구월동"));
		list.add(new PersonDTO("홍재범", 17, "서울 신림동"));
		list.add(new PersonDTO("문유리", 31, "부산 문래동"));
		list.add(new PersonDTO("김재민", 8, "인천 연수동"));
		list.add(new PersonDTO("장유라", 33, "부산 문래동"));
		
		model.addAttribute("list", list);
	}
}
