package com.spring.boot.springbootcontrolleradvice.Repository;

import com.spring.boot.springbootcontrolleradvice.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //DAO? data access object ?
    Employee findEmployeeById(Integer id);

    // turned into JPQL Java Persistent Query Language
    @Query("SELECT e from Employee e where e.id =?1")
    Employee giveMeById(Integer id);

    @Query("SELECT e from Employee e where e.name = ?1 and e.salary = ?2")
    Employee giveMeEmployeeByNameAndSalary(String name, Double salary);


    List<Employee> findEmployeesByNameAndSalary(String name, Double salary);

    // get employees by age where age>=the entered age
    @Query("select e from Employee e where e.age>=?1")
    List<Employee> giveMeEmployeesByAgeGraterThanOrEqual(Integer age);

}
