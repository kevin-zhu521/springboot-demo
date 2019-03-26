package com.zjf.service;

import com.zjf.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by Kevin Zhu on 2019/2/1 22:57 .
 */
public interface EmployeeService {

    public Employee getEmpById(Integer id);

    public Employee updateEmp(Employee employee);

    public void insertEmp(Employee employee);

    public void deleteEmp(Integer id);

}
