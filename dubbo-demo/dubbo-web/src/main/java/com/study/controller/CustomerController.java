package com.study.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.bean.Customer;
import com.study.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/27
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Reference
    private CustomerService customerService;

    @RequestMapping("/getCustomers")
    @ResponseBody
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
}
