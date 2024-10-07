package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;

@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberService memberService;
	
	@Test
	void 회원목록조회() {
		Page<MemberDTO> page = memberService.getList(1); // 0 또는 1
		List<MemberDTO> list = page.getContent();
				
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	void 등록() {
		MemberDTO dto = MemberDTO.builder()
							  .id("dasom")
							  .name("다솜")
							  .password("1234")
							  .build();
		
		boolean no = memberService.register(dto);
		
		System.out.println("처리 결과:"+no);
		
	}
	
	@Test
	void 단건조회() {
		MemberDTO dto = memberService.read("user1");
		System.out.println(dto);
	}
}
