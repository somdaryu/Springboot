package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>, QuerydslPredicateExecutor<Board> {
	
}

// 리파지토리 만드는 방법
// JpaRepository를 상속받는다
// 제네릭 타입에 엔티티와 PK타입을 쓴다