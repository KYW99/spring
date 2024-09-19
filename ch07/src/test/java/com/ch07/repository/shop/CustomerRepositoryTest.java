package com.ch07.repository.shop;



//CustomerRepository 확장 인터페이스 구현 클래스

import com.ch07.entity.shop.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest{

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectCustomer() {
        Customer customer = customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void selectProjectionCustomer() {
        List<Customer> customers = customerRepository.selectProjectionCustomer();
        System.out.println(customers);
    }


    @Test
    public void searchCustomer() {
        List<Customer> customer1 = customerRepository.searchCustomer("김춘추", 20);
        List<Customer> customer2 = customerRepository.searchCustomer("김춘추", 0);
        List<Customer> customer3 = customerRepository.searchCustomer(null, 20);
        List<Customer> customer4 = customerRepository.searchCustomer(null, 0);

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);

    }

    @Test
    public void searchKeyword() {
        
        List<Customer> customer1 = customerRepository.searchKeyword("춘추");
        List<Customer> customer2 = customerRepository.searchKeyword("부산진구");

        System.out.println(customer1);
        System.out.println(customer2);

    }
}

