package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;

@SpringBootTest
public class CommentRepositoryTest {
	@Autowired
	CommentRepository commentRepository;
	
	@Test
	public void 댓글등록() {
		Member member = Member.builder().id("user2").build();
		Board board = Board.builder().no(12).build();
		Comment comment = new Comment(0,board,"댓글입니다",member);
		commentRepository.save(comment);
//		Comment comment2 = new Comment(0,board,"댓글입니다",member);
//		commentRepository.save(comment2);
		
	}
	
	@Test
	public void 댓글목록조회() {
		List<Comment> list = commentRepository.findAll();
		for(Comment comment : list) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void 회원단건조회() {
		Optional<Comment> result = commentRepository.findById(1);
		
		if(result.isPresent()) {
			Comment comment = result.get();
			System.out.println(comment);
		}
	}
	
	@Test
	public void 회원수정() {
		Optional<Comment> optional = commentRepository.findById(1);
		Comment comment = optional.get();
		comment.setContent("수정~");
		commentRepository.save(comment);
	}
	
	@Test
	public void 댓글삭제() {

		commentRepository.deleteById(1);
		
	}
	
	@Test
	public void 게시물별_댓글조회() {
		//1번 게시물에 달린 댓글 목록 조회
		Board board = Board.builder()
							.no(11)
							.build();
		List<Comment> list = commentRepository.findByBoard(board);
		
		for(Comment comment : list) {
			System.out.println(comment);
		}
	}
	
	@Test
	public void 게시물별_댓글삭제() {
		Board board = Board.builder().no(11).build();
		commentRepository.deleteByBoard(board);
	}
	
	
}
