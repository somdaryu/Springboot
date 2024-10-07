package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {

	@Autowired
	CommentService service;
	
	@Test
	public void 게시물별댓글조회() {
		List<CommentDTO> list = service.getListByBoardNo(12);
		
		for(CommentDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 댓글등록() {
		CommentDTO dto = CommentDTO.builder()
									.content("댓글입니다~")
									.boardNo(11)
									.writer("user1")
									.build();
		service.register(dto);
	}
	
	@Test
	public void 댓글삭제() {
		boolean result = service.remove(5);
		System.out.println(result);
	}
}
