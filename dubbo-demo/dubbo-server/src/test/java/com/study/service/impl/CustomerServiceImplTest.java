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
@ContextConfiguration({"classpath:spring/spring-core.xml", "classpath:spring/spring-registry.xml"})
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

    @Test
    public void updateCustomerById() throws Exception {
        Customer customer = customerService.updateCustomerById(27);
        System.out.println(customer);
    }
}