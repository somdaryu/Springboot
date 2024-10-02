package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository repository;
	
	@Test
	void 게시물등록() {
		//테이블에 존재하는 회원 정보로 엔티티 생성(PK만 필요)
		Member member = Member.builder()
							  .id("user2")
							  .build();

		Board board1 = Board.builder()
						   .title("안녕하세요")
						   .content("안녕하세요")
						   .writer(member)
						   .build();
		

		Board board2 = Board.builder()
					   .title("반갑습니다")
					   .content("반갑습니다")
					   .writer(member)
					   .build();

		repository.save(board1);
		repository.save(board2);
	}
	
	@Test
	public void 게시물단건조회() {
		Optional<Board> optional = repository.findById(1);
		
		Board board = optional.get();
		
		System.out.println(board);
		
		//SQL 쿼리에서 board 테이블과 member 테이블이 JOIN 처리됨
		//게시물 정보에 작성자(회원) 정보가 포함됨
		
	}
	
	@Test
	void 게시물삭제() {
		repository.deleteAll();
	}
	
}
