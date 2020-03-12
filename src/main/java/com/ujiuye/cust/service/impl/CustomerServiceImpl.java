package com.ujiuye.cust.service.impl;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.dao.CustomerMapper;
import com.ujiuye.cust.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public void saveInfo(Customer customer) {
        customer.setAddtime(new Date());
        customerMapper.saveInfo(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerMapper.getCustomerList();
    }

    @Override
    public Customer getCustomerInfoById(Integer cid) {
        return customerMapper.getCustomerInfoById(cid);
    }

    @Override
    public void updateCustomerInfo(Customer customer) {
        customerMapper.updateCustomerInfo(customer);
    }

    @Override
    public boolean batchDelete(String ids) {
        String[] split = ids.split(",");
        int num = customerMapper.batchDelete(split);
        return split.length == num;
    }

    @Override
    public List<Customer> search(int cid, String keyword, int orderby) {
        return customerMapper.search(cid,keyword,orderby);
    }
}
