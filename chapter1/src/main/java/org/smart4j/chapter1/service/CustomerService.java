package org.smart4j.chapter1.service;

import org.smart4j.chapter1.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CustomerService
 * @Description TODO
 * @Author Administrator
 * @Date 2018/9/23 23:23
 * @Version 1.0
 */
public interface CustomerService {

    /**
     * @param params
     * @return
     */
    List<Customer> getCustomerList(Map<String, Object> params);

    /**
     * @param id
     * @return
     */
    Customer getCustomer(Long id);

    /**
     * @param customer
     * @return
     */
    boolean createCustomer(Customer customer);

    /**
     * @param customer
     * @return
     */
    boolean updateCustomer(Customer customer);

    /**
     * @param id
     * @return
     */
    boolean deleteCustomer(Long id);
}
