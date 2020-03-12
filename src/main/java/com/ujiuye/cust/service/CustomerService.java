package com.ujiuye.cust.service;

import com.ujiuye.cust.bean.Customer;

import java.util.List;

public interface CustomerService {
    void saveInfo(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerInfoById(Integer cid);

    void updateCustomerInfo(Customer customer);

    boolean batchDelete(String ids);

    List<Customer> search(int cid, String keyword, int orderby);
}
