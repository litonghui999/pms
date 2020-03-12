package com.ujiuye.cust.dao;

import com.ujiuye.cust.bean.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    void saveInfo(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerInfoById(Integer cid);

    void updateCustomerInfo(Customer customer);

    int batchDelete(String[] split);

    List<Customer> search(@Param("cid") int cid,@Param("keyword") String keyword,@Param("orderby") int orderby);
}
