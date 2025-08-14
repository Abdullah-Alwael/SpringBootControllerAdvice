package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.Employee;
import com.spring.boot.springbootcontrolleradvice.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<?> getEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Employee added successfully"));

    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer employeeId,
                                            @Valid @RequestBody Employee employee){

        employeeService.updateEmployee(employeeId,employee);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Employee updated"));

    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId){

        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Employee deleted"));

    }

    @GetMapping("/list/by-name-and-salary/{employeeName}/{salary}")
    public ResponseEntity<?> getEmployeesByNameAndSalary(@PathVariable String employeeName,
                                                         @PathVariable Double salary){

        return ResponseEntity.status(HttpStatus.OK).body(
                employeeService.getEmployeesByNameAndSalary(employeeName,salary));
    }

    @GetMapping("/filter/age/{age}")
    public ResponseEntity<?> getEmployeeByAge(@PathVariable Integer age){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByAge(age));
    }
}
