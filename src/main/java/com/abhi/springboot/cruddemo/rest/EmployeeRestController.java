package com.abhi.springboot.cruddemo.rest;

import com.abhi.springboot.cruddemo.entity.Employee;
import com.abhi.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("EmployeeId does not exist");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);
        Employee newEmployee=employeeService.save(employee);

        return newEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee newEmployee=employeeService.save(employee);
        return newEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Given Employee ID does not exist");
        }
        employeeService.deleteById(employeeId);
        return "Given Employee ID deleted";
    }
}
