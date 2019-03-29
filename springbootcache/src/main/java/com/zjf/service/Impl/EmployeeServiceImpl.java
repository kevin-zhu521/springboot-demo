package com.zjf.service.Impl;

import com.zjf.bean.Employee;
import com.zjf.mapper.EmployeeMapper;
import com.zjf.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kevin Zhu on 2019/2/1 22:57 .
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "emp")
public class EmployeeServiceImpl implements EmployeeService {
    private String names = "";

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
//    @Cacheable(key = "'emp_' + #id")
    public Employee getEmpById(Integer id) {
        log.info("查询出员工:" + id);
        return employeeMapper.getEmpById(id);
    }

    @Override
//    @CachePut(key = "'emp_' + #employee.id")
    public Employee updateEmp(Employee employee) {
        log.info("更新员工:" + employee.getId());
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @Override
    public void insertEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
    }

    @Override
//    @CacheEvict(key = "'emp_' + #id")
    public void deleteEmp(Integer id) {
//        employeeMapper.deleteEmp(id);
        log.info("删除员工:" + id);

    }
}
