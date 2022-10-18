package com.heyq.rest.controller;

import com.heyq.rest.bean.Employee;
import com.heyq.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author heyq
 * @create 2022-10-08-15:22
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //查询所有用户信息GET
    @RequestMapping(value = "/employee" ,method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeelist = employeeDao.getAll();
        model.addAttribute("employeelist",employeelist);
        return "employee_list";
    }

    //根据id删除指定用户DELETE
    @RequestMapping(value = "/employee/{id}" ,method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    //添加用户信息POST
    @RequestMapping(value = "/employee" ,method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //根据id查询，并回显
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }
    //根据回显的用户修改信息
    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateRmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
