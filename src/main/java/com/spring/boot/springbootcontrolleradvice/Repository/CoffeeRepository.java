package com.spring.boot.springbootcontrolleradvice.Repository;

import com.spring.boot.springbootcontrolleradvice.Model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    Coffee findCoffeeById(Integer id);

    @Query("select c from Coffee c where c.id=?1")
    Coffee giveMeById(Integer id);

    @Query("select c from Coffee c where c.empId=?1")
    Coffee giveMeByEmpId(Integer empId);

    List<Coffee> findCoffeeByEmpId(Integer empId);

    //    get coffee by category
    @Query("SELECT c from Coffee c where c.category=?1")
    List<Coffee> giveMeCoffeeByCategory(String category);
}
