package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository repository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 회원등록() {
		Member member = Member.builder()
				.id("user1")
				.name("둘리")
				.password("1234")
				.build();
		
		Member member2 = Member.builder()
				.id("user2")
				.name("또치")
				.password("1234")
				.build();

	repository.save(member);
	repository.save(member2);
	}
	
	@Test
	public void 회원목록조회() {
		List<Member> list = repository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	@Test
	public void 회원단건조회() {
		Optional<Member> result = repository.findById("user1");
		
		if(result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
	}
	
	@Test
	public void 회원수정() {
		Optional<Member> optional = repository.findById("user1");
		Member member = optional.get();
		member.setName("또치");
		repository.save(member);
	}
	
	@Test
	public void 첫번째회원삭제() {
		
		//게시물이 작성한 회원은 바로 삭제할 수 없음
		//회원을 삭제하려면 먼저 회원이 작성한 게시물을 삭제해야함
		
		repository.deleteById("user1");
		
		//데이터 추가: 부모 > 자식
		//데이터 삭제: 자식 > 부모
	}
	
	@Test
	public void 두번째회원삭제() {
		repository.deleteById("user2");
	}
	
	@Test
	public void 회원삭제() {
		//회원 엔티티로 데이터를 추가할 때 : 모든 데이터 작성
		//회원 엔티티를 이용할 때 : pk만 작성
		Member member = Member.builder().id("user2").build();
		
		// 해당 회원이 작성한 모든 글을 삭제
		boardRepository.deleteWriter(member);
		// 그 후에 회원을 삭제
		repository.deleteById("user2");
		
	}
	
	@Test
	public void 회원일괄등록() {
		List<Member> list = new ArrayList<>();
		for (int i = 1; i <= 30; i++) {
			list.add(new Member("user" + i, "1234", "둘리"));
		}
		repository.saveAll(list);
	}
	
}
