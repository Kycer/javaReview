package com.study.service;

import com.study.bean.Customer;

import java.util.List;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/26
 */
public interface CustomerService {
    Customer getCustomerById(Integer id);
    List<Customer> getCustomers();
    Customer updateCustomerById(Integer id);
}
