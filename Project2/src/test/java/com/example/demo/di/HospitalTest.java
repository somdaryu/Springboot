package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HospitalTest {

	@Autowired
	Doctor doctor;
	
	@Autowired
	Hospital hospital;
	
	@Test
	void 연습문제5() {
		System.out.println("hospital :"+ hospital);
		System.out.println("doctor :"+ doctor);
		System.out.println("hospital.doctor : "+hospital.doctor);
	}
}
