package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderNo;
	
	@Column(length = 30, nullable = false)
	String customerName;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(nullable = false)
	LocalDate orderDate;
	
	@Column(length = 100)
	String shipAddress;
}
