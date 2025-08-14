package com.spring.boot.springbootcontrolleradvice.Service;

import com.spring.boot.springbootcontrolleradvice.Api.ApiException;
import com.spring.boot.springbootcontrolleradvice.Model.Employee;
import com.spring.boot.springbootcontrolleradvice.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // no need to return boolean any longer
    public void updateEmployee(Integer employeeId, Employee employee) {
        Employee oldEmployee = employeeRepository.giveMeById(employeeId);

        if (oldEmployee == null) {
            throw new ApiException("Employee not found");
        }

        oldEmployee.setName(employee.getName());
        oldEmployee.setSalary(employee.getSalary());
        oldEmployee.setIsLeave(employee.getIsLeave());

        employeeRepository.save(oldEmployee);
    }

    public void deleteEmployee(Integer employeeId){
        Employee oldEmployee = employeeRepository.findEmployeeById(employeeId);

        if (oldEmployee == null) {
            throw new ApiException("Employee not found");
        }

        employeeRepository.delete(oldEmployee);
    }

    public Employee getEmployeesByNameAndSalary(String employeeName, Double salary){
        return employeeRepository.giveMeEmployeeByNameAndSalary(employeeName,salary);
    }

    public List<Employee> getEmployeeByAge(Integer age){
        return employeeRepository.giveMeEmployeesByAgeGraterThanOrEqual(age);
    }

    public Boolean doesNotExist(Integer employeeId){
        return !employeeRepository.existsById(employeeId);
    }
}
