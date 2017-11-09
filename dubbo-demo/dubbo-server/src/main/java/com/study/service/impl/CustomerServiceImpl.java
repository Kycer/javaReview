package com.study.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.bean.Customer;
import com.study.bean.CustomerExample;
import com.study.mapper.CustomerMapper;
import com.study.service.CustomerService;
import org.apache.ibatis.executor.ExecutorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
//    @Transactional
    public Customer updateCustomerById(Integer id) {
        Customer customer = customerMapper.selectByPrimaryKey(id);
        customer.setCode("1111111");
        customerMapper.updateByPrimaryKeySelective(customer);
        if(customer.getIsSign() == 1){
            throw new RuntimeException("有值");
        }
        return customer;
    }
}
