package com.ujiuye.pro.service.impl;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.dao.CustomerMapper;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.emp.dao.EmployeeMapper;
import com.ujiuye.pro.bean.Project;
import com.ujiuye.pro.bean.ProjectExample;
import com.ujiuye.pro.dao.ProjectMapper;
import com.ujiuye.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public void saveInfo(Project project) {
        projectMapper.insert(project);
    }

    @Override
    public List<Project> getProjectJsonList() {
        ProjectExample example= new ProjectExample();
        List<Project> projects = projectMapper.selectByExample(example);
        for (Project project : projects) {
            Integer cid = project.getComname();
            Customer customer= customerMapper.getCustomerInfoById(cid);
            project.setCustomer(customer);
            Integer empFk = project.getEmpFk();
            Employee employee=employeeMapper.getEmployeeById(empFk);
            project.setEmployee(employee);
        }
        return projects;
    }

}
