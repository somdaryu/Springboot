package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieTest {
	@Test
	void 연습문제4() {
		Movie movie1 = new Movie();
		movie1.setTitle("아이언맨");
		movie1.setDirector("존파브로");
		movie1.setDate("2008-04-30");
		
		System.out.println(movie1.getTitle());
		System.out.println(movie1.getDirector());
		System.out.println(movie1.getDate());
		
		Movie movie2 = new Movie("베테랑2", "류승완", "2024-09-13");
		System.out.println(movie2.toString());
		
		Movie movie3 = Movie
							.builder()
							.title("파일럿")
							.director("김한결")
							.date("2024-07-31")
							.build();
		System.out.println(movie3.toString());
	}
}
