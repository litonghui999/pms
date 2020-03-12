package com.ujiuye.emp.service.impl;

import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.dao.EmployeeMapper;
import com.ujiuye.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = employeeMapper.getEmployeeList();
        return employeeList;
    }

    @Override
    public List<Employee> getManagerList() {
        return employeeMapper.getManagerList();
    }
}
