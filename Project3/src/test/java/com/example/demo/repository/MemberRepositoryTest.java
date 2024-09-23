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
	MemberRepository memberRepository;
	
	@Test
	public void 가져왔는지() {
		System.out.println(memberRepository);
	}
	
	@Test
	public void 데이터일괄등록() {
		List<Member> list = new ArrayList<>();
		Member member1 = Member.builder()
								.userId("admin")
								.grade("관리자")
								.password("1234")
								.build();
		
		Member member2 = Member.builder()
								.userId("user1")
								.grade("사용자")
								.password("1234")
								.build();
		
		Member member3 = Member.builder()
								.userId("user2")
								.grade("사용자")
								.password("1234")
								.build();
		
		Member member4 = Member.builder()
								.userId("yoyt22")
								.grade("관리자")
								.password("1234")
								.build();
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		memberRepository.saveAll(list);
	}
	
	@Test
	public void 데이터전체조회() {
		List<Member> list =  memberRepository.findAll();
		
		for(Member member : list) { 
			System.out.println(member);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Member> optional = memberRepository.findById("user1");
		Member member = optional.get();
		member.setGrade("관리자");
		memberRepository.save(member);
	}
	
	@Test
	public void 데이터삭제() {
		memberRepository.deleteById("user1");
	}
}
