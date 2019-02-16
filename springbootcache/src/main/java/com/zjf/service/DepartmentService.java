package com.zjf.service;

import com.zjf.bean.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Kevin Zhu on 2019/2/1 23:51 .
 */
public interface DepartmentService {

    public Department getDepById(Integer id);

    public void updateDep(Department department);

    public void insertDep(Department department);

    public void deleteDep(Integer id);
}
