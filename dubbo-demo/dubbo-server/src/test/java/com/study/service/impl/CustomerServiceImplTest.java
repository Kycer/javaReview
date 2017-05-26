package com.study.service.impl;


import com.study.bean.Customer;
import com.study.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;
    @Test
    public void getCustomerById() {
        Customer customer = customerService.getCustomerById(10);
        System.out.println(customer);
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        System.out.println(customers);
    }

}