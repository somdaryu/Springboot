package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 데이터조회() {
		System.out.println("bookRepository :"+bookRepository);
	}
	
	@Test
	public void 데이터추가() {
		Book book = Book.builder()
						.price(20000)
						.publisher("한빛출판사")
						.title("자바프로그래밍입문")
						.build();
		
		bookRepository.save(book);
	}
	
	@Test
	public void 데이터일괄등록() {
		// 메모 리스트 생성
		List<Book> list = new ArrayList<>();
		Book book2 = Book.builder()
						.price(25000)
						.publisher("남가람북스")
						.title("스프링부트프로젝트")
						.build();
		
		Book book3 = Book.builder()
				.price(40000)
				.publisher("남가람북스")
				.title("실무로 끝내는 PHP")
				.build();
		
		Book book4 = Book.builder()
				.price(35000)
				.publisher("이지스퍼블리싱")
				.title("알고리즘코딩테스트")
				.build();


		list.add(book2);
		list.add(book3);
		list.add(book4);

		bookRepository.saveAll(list);
	}
	
	@Test
	public void 데이터전체조회() {
		//findAll: 테이블에 있는 모든 데이터를 조회하는 함수
		List<Book> list =  bookRepository.findAll();
		
		for(Book book : list) { //리스트 or 배열
			System.out.println(book);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Book> optional = bookRepository.findById(1);
		Book book = optional.get();
		book.setPrice(30000);
		bookRepository.save(book);
	}
	
	@Test
	public void 데이터삭제() {
		bookRepository.deleteById(1);
	}

}
