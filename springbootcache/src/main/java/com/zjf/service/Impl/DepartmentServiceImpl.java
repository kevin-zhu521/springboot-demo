package com.zjf.service.Impl;

import com.zjf.bean.Department;
import com.zjf.mapper.DepartmentMapper;
import com.zjf.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kevin Zhu on 2019/2/1 23:52 .
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepById(Integer id) {
        return departmentMapper.getDepById(id);
    }

    @Override
    public void updateDep(Department department) {
        departmentMapper.updateDep(department);
    }

    @Override
    public void insertDep(Department department) {
        departmentMapper.insertDep(department);
    }

    @Override
    public void deleteDep(Integer id) {
        departmentMapper.deleteDep(id);
    }
}
