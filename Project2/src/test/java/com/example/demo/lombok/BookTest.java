package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
	@Test
	void 연습문제1() {
		Book book1 = new Book();
		book1.setTitle("자바");
		book1.setPrice(10000);
		book1.setPublisher("한빛");
		book1.setPage(200);
		System.out.println(book1.getTitle());
		System.out.println(book1.getPrice());
		System.out.println(book1.getPublisher());
		System.out.println(book1.getPage());
		
		Book book2 = new Book("DB", 20000, "한빛", 300);
		System.out.println(book2.toString());
		
		Book book3 = Book
							.builder()
							.title("스프링")
							.price(15000)
							.publisher("금빛")
							.page(180)
							.build();
		System.out.println(book3.toString());
	}
	
}
