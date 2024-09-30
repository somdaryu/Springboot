package com.example.demo.repository;

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
	public void 회원삭제() {
		repository.deleteById("user1");
	}
}
