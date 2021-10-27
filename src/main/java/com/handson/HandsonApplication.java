package com.handson;

import com.handson.entity.*;
import com.handson.repository.CustomerRepository;
import com.handson.repository.ProductRepository;
import com.handson.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HandsonApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(HandsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started !!");

		ProductEntity p1 = new ProductEntity(1,"Java Complete Reference", Constants.BOOKS_CATEGORY,450.50);
		ProductEntity p2 = new ProductEntity(2,"Programming in Java", Constants.BOOKS_CATEGORY,99.50);
		ProductEntity p3 = new ProductEntity(3,"Practical Programming in Java", Constants.BOOKS_CATEGORY,350.50);
		ProductEntity p4 = new ProductEntity(4,"Head First Java", Constants.BOOKS_CATEGORY,250.50);
		ProductEntity p5 = new ProductEntity(5,"Soft Toys", Constants.TOYS_CATEGORY,150.50);
		ProductEntity p6 = new ProductEntity(6,"Plastic Toys", Constants.TOYS_CATEGORY,175.50);
		ProductEntity p7 = new ProductEntity(7,"Bath soap", Constants.BABY_CATEGORY,75.50);
		ProductEntity p8 = new ProductEntity(8,"Baby Oil", Constants.BABY_CATEGORY,225.50);
		ProductEntity p9 = new ProductEntity(9,"Baby lotion", Constants.BABY_CATEGORY,275.50);
		List<ProductEntity> productsList = new ArrayList<>();
		productsList.add(p1);
		productsList.add(p2);
		productsList.add(p3);
		productsList.add(p4);
		productsList.add(p5);
		productsList.add(p6);
		productsList.add(p7);
		productsList.add(p8);
		productsList.add(p9);
		productRepository.saveAll(productsList);

		//////////////////Order-1//////////////////
		OrderEntity order1 = new OrderEntity();
		order1.setId(101);
		order1.setStatus("Delivered");
		order1.setOrderDate(LocalDate.now().minusWeeks(1));
		order1.setDeliveryDate(LocalDate.now());
		order1.getProducts().add(p1);
		order1.getProducts().add(p2);
		order1.getProducts().add(p3);

		CustomerEntity customer1 = new CustomerEntity();
		order1.setCustomer(customer1);
		customer1.setId(1);
		customer1.setName("Lakshmi");
		customer1.setTier(31);
		customer1.getOrders().add(order1);
		customerRepository.save(customer1);
		///////////////////

		//////////////////Order-2//////////////////
		OrderEntity order2 = new OrderEntity();
		order2.setId(102);
		order2.setStatus("In Transit");
		order2.setOrderDate(LocalDate.now().minusDays(3));
		order2.setDeliveryDate(LocalDate.now().plusDays(4));
		order2.getProducts().add(p4);
		order2.getProducts().add(p5);
		order2.getProducts().add(p6);
		order2.getProducts().add(p9);
		CustomerEntity customer2 = new CustomerEntity();
		order2.setCustomer(customer2);
		customer2.setId(2);
		customer2.setName("Rajesh");
		customer2.setTier(32);
		customer2.getOrders().add(order2);
		customerRepository.save(customer2);
		///////////////////

		//////////////////Order-3//////////////////
		OrderEntity order3 = new OrderEntity();
		order3.setId(103);
		order3.setStatus("Ordered");
		order3.setOrderDate(LocalDate.now());
		order3.setDeliveryDate(LocalDate.now().plusDays(7));
		order3.getProducts().add(p7);
		order3.getProducts().add(p8);
		order3.getProducts().add(p9);
		CustomerEntity customer3 = new CustomerEntity();
		order3.setCustomer(customer3);
		customer3.setId(3);
		customer3.setName("Rao");
		customer3.setTier(33);
		customer3.getOrders().add(order3);
		customerRepository.save(customer3);
		///////////////////

		//////////////////Order-4//////////////////
		OrderEntity order4 = new OrderEntity();
		order4.setId(104);
		order4.setStatus("Shipment");
		order4.setOrderDate(LocalDate.now().minusDays(5));
		order4.setDeliveryDate(LocalDate.now().plusDays(1));
		order4.getProducts().add(p1);
		order4.getProducts().add(p2);
		order4.getProducts().add(p6);
		CustomerEntity customer4 = new CustomerEntity();
		order4.setCustomer(customer4);
		customer4.setId(4);
		customer4.setName("Sarma");
		customer4.setTier(34);
		customer4.getOrders().add(order4);
		customerRepository.save(customer4);
		///////////////////

		//////////////////Order-5//////////////////
		OrderEntity order5 = new OrderEntity();
		order5.setId(105);
		order5.setStatus("Shipment");
		order5.setOrderDate(LocalDate.now().minusDays(5));
		order5.setDeliveryDate(LocalDate.now().plusDays(2));
		order5.getProducts().add(p2);
		order5.getProducts().add(p6);
		order5.getProducts().add(p9);
		CustomerEntity customer5 = new CustomerEntity();
		order5.setCustomer(customer5);
		customer5.setId(5);
		customer5.setName("Pamarthi");
		customer5.setTier(35);
		customer5.getOrders().add(order5);
		customerRepository.save(customer5);
		///////////////////
	}
}
