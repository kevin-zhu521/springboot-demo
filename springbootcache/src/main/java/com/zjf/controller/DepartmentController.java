package com.zjf.controller;

import com.zjf.aspect.log.MethodLog;
import com.zjf.bean.Employee;
import com.zjf.service.EmployeeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kevin Zhu on 2019/2/1 23:55 .
 */
@RestController
public class DepartmentController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    @MethodLog("第一次测试日志记录")
    public Employee getEmpById(@PathVariable Integer id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping("/emp/update")
    public void updateEmp() {
        Employee employee = employeeService.getEmpById(1);
        employee.setLastName("kevin");
        employeeService.updateEmp(employee);
    }

    @GetMapping("/emp/delete")
    public void deleteEmp() {
        employeeService.deleteEmp(1);
    }

    @GetMapping("/json/test")
    public Object jsonTest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","1");
        jsonObject.put("b","2");
        return jsonObject;
    }

}
