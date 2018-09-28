package org.smart4j.chapter1.service.impl;

import org.smart4j.chapter1.model.Customer;
import org.smart4j.chapter1.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomerServiceImpl
 * @Description 客户服务类
 * @Author Administrator
 * @Date 2018/9/25 21:32
 * @Version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> getCustomerList(Map<String, Object> params) {
        return null;
    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return false;
    }
}
