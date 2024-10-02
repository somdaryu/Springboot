package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

// insert, update, delete 기능을 사용할 때 추가
// commit 처리
@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer>, QuerydslPredicateExecutor<Board> {
	// 특정 회원이 작성한 모든 게시물을 삭제하는 메소드
	// jpql 사용
	@Modifying
	@Query("delete from Board where writer = :mem")
	public void deleteWriter(@Param("mem") Member member);
}

// 리파지토리 만드는 방법
// JpaRepository를 상속받는다
// 제네릭 타입에 엔티티와 PK타입을 쓴다