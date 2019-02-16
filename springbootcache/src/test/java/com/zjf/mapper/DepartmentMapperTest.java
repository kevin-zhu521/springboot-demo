package com.zjf.mapper;

import ch.qos.logback.classic.Logger;
import com.zjf.SpringbootcacheApplicationTests;
import com.zjf.bean.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Kevin Zhu on 2019/2/1 23:19 .
 */
@Slf4j
public class DepartmentMapperTest extends SpringbootcacheApplicationTests {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void getDepById() throws Exception {
        Department dep = departmentMapper.getDepById(1);
        log.info("部门为:{}" + dep);
    }

    @Test
    public void updateDep() throws Exception {
        Department department = new Department();
        department.setId(2);
        department.setDepartmentName("产品创新部");
        departmentMapper.updateDep(department);
        log.info("已经更新");
    }

    @Test
    public void insertDep() throws Exception {
        Department department = new Department();
        department.setId(3);
        department.setDepartmentName("人事部");
        departmentMapper.insertDep(department);
        log.info("已经新增");
    }

    @Test
    public void deleteDep() throws Exception {
        departmentMapper.deleteDep(3);
        log.info("已经删除");
    }

}