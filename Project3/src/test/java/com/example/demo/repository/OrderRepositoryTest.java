package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 연결확인() {
		System.out.println(orderRepository);
	}
	
	@Test
	public void 데이터일괄등록() {
		LocalDate localDate1 = LocalDate.of(2023, 7, 1);
		LocalDate localDate2 = LocalDate.of(2023, 7, 2);
		LocalDate localDate3 = LocalDate.of(2023, 7, 3);
		
		//order를 생성할때 date를 같이 생성한다 LocalDate.of(2023,7,2)
		List<Order> list = new ArrayList<>();
		Order order1 = Order.builder()
							.customerName("둘리")
							.shipAddress("인천 구월동")
							.orderDate(localDate1)
							.build();
		
		Order order2 = Order.builder()
							.customerName("또치")
							.shipAddress("인천 연수동")
							.orderDate(localDate2)
							.build();
		
		Order order3 = Order.builder()
							.customerName("도우너")
							.shipAddress("부산 동래동")
							.orderDate(localDate3)
							.build();
		
		Order order4 = Order.builder()
							.customerName("마이콜")
							.orderDate(localDate1)
							.build();
		
		Order order5 = Order.builder()
							.customerName("고길동")
							.orderDate(localDate2)
							.build();
				
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		orderRepository.saveAll(list);
	}
	
	@Test
	public void 데이터전체조회() {
		List<Order> list =  orderRepository.findAll();
		
		for(Order order : list) { 
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> optional = orderRepository.findById(1);
		Order order = optional.get();
		order.setCustomerName("짱구");
		orderRepository.save(order);
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1);
	}
}
