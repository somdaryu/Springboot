package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

//단위테스트시 데이터를 삭제할때 commit처리해주는 어노테이션
@Transactional
//리파지토리 : 엔티티를 사용하여 데이터를 처리 (crud, 페이징, 정렬)
public interface MemoRepository extends JpaRepository<Memo, Integer>{
	//메모의 번호가 10에서 20사이인 데이터 검색
	//검색에 필요한 파라미터는 매개변수로 선언
	//where no between ? and ?
	List<Memo> findByNoBetween(int from, int to);
	
	//메모의 번호가 10보다 작은 데이터 검색
	//where no < ?
	List<Memo> findByNoLessThan(int mno);
	
	//메모의 내용이 없는 데이터 검색
	//where text is not null
	List<Memo> findByTextIsNotNull();
	
	//메모의 번호를 기준으로 역정렬
	//order by no desc
	List<Memo> findAllByOrderByNoDesc();
	
	//메모의 번호가 3보다 작은 데이터 삭제
	//delete from tbl_memo where no<?
	void deleteMemoByNoLessThan(int mno);
	
}

//JpaRepository를 생성할 때는 엔티티와 해당엔티티의 PK타입(래퍼클래스)을 지정해야 한다.