package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {

	@Test
	void 연습문제2() {
		Car car1 = new Car();
		car1.setModel("아반떼");
		car1.setCompany("현대");
		car1.setColor("흰색");
		
		System.out.println(car1.getModel());
		System.out.println(car1.getCompany());
		System.out.println(car1.getColor());
		
		Car car2 = new Car("제네시스", "현대", "검정");
		System.out.println(car2.toString());
		
		Car car3 = Car
						.builder()
						.model("모닝")
						.company("기아")
						.color("베이지")
						.build();
		System.out.println(car3.toString());
	}
}
