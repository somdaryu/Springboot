package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
	
	@Test
	void 연습문제3() {
		Student student1 = new Student();
		
		student1.setStuNum(1);
		student1.setName("둘리");
		student1.setAge(16);
		
		System.out.println(student1.getStuNum());
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		
		Student student2 = new Student(2,"또치",17);
		System.out.println(student2.toString());
		
		Student student3 = Student
									.builder()
									.stuNum(3)
									.name("도우너")
									.age(16)
									.build();
		System.out.println(student3.toString());
		
	}
}
