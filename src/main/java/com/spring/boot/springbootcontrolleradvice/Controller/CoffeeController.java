package com.spring.boot.springbootcontrolleradvice.Controller;

import com.spring.boot.springbootcontrolleradvice.Api.ApiResponse;
import com.spring.boot.springbootcontrolleradvice.Model.Coffee;
import com.spring.boot.springbootcontrolleradvice.Service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    public final CoffeeService coffeeService;

    @GetMapping("/list")
    public ResponseEntity<?> getALlCoffee() {
        return ResponseEntity.status(HttpStatus.OK).body(coffeeService.getCoffees());
    }

    @PostMapping("/new")
    public ResponseEntity<?> addCoffee(@Valid @RequestBody Coffee coffee) {
        coffeeService.addCoffee(coffee);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Coffee added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCoffee(@PathVariable Integer id, @Valid @RequestBody Coffee coffee) {
        coffeeService.updateCoffee(id, coffee);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Updated successfully"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCoffee(@PathVariable Integer id) {

        coffeeService.deleteCoffee(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Deleted successfully"));

    }

    @GetMapping("/list/by-employee-id/{employeeId}")
    public ResponseEntity<?> getCoffeeByEmployeeId(@PathVariable Integer employeeId){
        return ResponseEntity.status(HttpStatus.OK).body(coffeeService.getCoffeeByEmployeeId(employeeId));
    }

    @GetMapping("filter/category/{category}")
    public ResponseEntity<?> getCoffeeByCategory(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(coffeeService.getCoffeeByCategory(category));
    }
}
