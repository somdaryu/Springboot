package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
	@Autowired
	Employee employee;
	
	@Test
	void 연습문제3() {
		employee.work();
	}
}
