package com.zjf.service.Impl;

import com.zjf.bean.Employee;
import com.zjf.mapper.EmployeeMapper;
import com.zjf.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin Zhu on 2019/2/1 22:57 .
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private String names="";

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @Cacheable(cacheNames = "emp",key = "#root.target+#id")
    public Employee getEmpById(Integer id) {
        log.info("查询出员工:"+id);
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }
}
