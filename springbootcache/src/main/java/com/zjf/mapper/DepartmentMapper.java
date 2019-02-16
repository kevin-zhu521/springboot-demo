package com.zjf.mapper;

import com.zjf.bean.Department;
import com.zjf.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by Kevin Zhu on 2019/2/1 22:57 .
 */
@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id}")
    public Department getDepById(Integer id);

    @Update("UPDATE department SET department_name = #{departmentName} WHERE id = #{id}")
    public void updateDep(Department department);

    @Insert("INSERT INTO department(id, department_name) VALUES (#{id}, #{departmentName})")
    public void insertDep(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    public void deleteDep(Integer id);
}
