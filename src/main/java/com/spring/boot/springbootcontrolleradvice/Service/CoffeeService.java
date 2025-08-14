package com.spring.boot.springbootcontrolleradvice.Service;

import com.spring.boot.springbootcontrolleradvice.Api.ApiException;
import com.spring.boot.springbootcontrolleradvice.Model.Coffee;
import com.spring.boot.springbootcontrolleradvice.Repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final EmployeeService employeeService;

    public List<Coffee> getCoffees(){
        return coffeeRepository.findAll();
    }

    public void addCoffee(Coffee coffee){
        if (employeeService.doesNotExist(coffee.getEmpId())){
            throw new ApiException("Error, employee does not exist");
        }
        coffeeRepository.save(coffee);
    }

    public void updateCoffee(Integer id, Coffee coffee){

        Coffee oldCoffee = coffeeRepository.findCoffeeById(id);

        if (oldCoffee == null){
            throw  new ApiException("Coffee not found");
        }

        oldCoffee.setName(coffee.getName());
        oldCoffee.setCategory(coffee.getCategory());
        oldCoffee.setPrice(coffee.getPrice());

        coffeeRepository.save(oldCoffee);

    }

    public void deleteCoffee(Integer id){
        Coffee oldCoffee = coffeeRepository.giveMeById(id);

        if (oldCoffee == null){
            throw  new ApiException("Coffee not found");
        }

        coffeeRepository.delete(oldCoffee);
    }

    public Coffee getCoffeeByEmployeeId(Integer employeeId){
        return coffeeRepository.giveMeByEmpId(employeeId);
    }

    public List<Coffee> getCoffeeByCategory(String category){
        return coffeeRepository.giveMeCoffeeByCategory(category);
    }
}
