package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //스프링 컨테이너 환경
public class PersonTest {
	
	@Test //단위테스트
	void 롬복테스트() {
		Person person1 = new Person(); //디폴트 생성자
		
		person1.setName("둘리");//setter
		person1.setAge(12);
		
		System.out.println(person1.getName()); //getter
		System.out.println(person1.getAge());
		
		Person person2 = new Person("또치", 15);
		System.out.println(person2.toString());
		
		//builder: 메소드 체인 패턴으로 객체를 생성하는 생성자
		//값을 선택하여 입력할 수 있음
		Person person3 = Person
								.builder() //준비
								.name("도우너") //필드
								.age(17) //필드
								.build(); //객체 생성
		System.out.println(person3);
	}
}
