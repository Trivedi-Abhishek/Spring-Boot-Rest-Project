package com.abhi.springboot.cruddemo.service;

import com.abhi.springboot.cruddemo.DAO.EmployeeRepository;
import com.abhi.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> obj = employeeRepository.findById(id);

        Employee employee=null;
        if(obj.isPresent()){
            employee=obj.get();
        }
        else{
            throw new RuntimeException("Did not found given Employee ID");
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }


}
