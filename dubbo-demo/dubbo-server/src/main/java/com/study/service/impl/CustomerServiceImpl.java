package com.study.service.impl;

import com.study.bean.Customer;
import com.study.bean.CustomerExample;
import com.study.mapper.CustomerMapper;
import com.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/26
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Customer> getCustomers() {
        CustomerExample ce = new CustomerExample();
        return customerMapper.selectByExample(ce);
    }
}
