package com.zjf.mapper;

import com.zjf.bean.Department;
import com.zjf.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by Kevin Zhu on 2019/2/1 22:57 .
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET last_name = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} WHERE id = #{id}")
    public void updateEmp(Employee employee);

    @Insert("INSERT INTO employee(id, last_name, email, gender, i_id) VALUES (#{id}, #{lastName}, #{email}, #{gender}, #{dId})")
    public void insertEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id = #{id}")
    public void deleteEmp(Integer id);
}
