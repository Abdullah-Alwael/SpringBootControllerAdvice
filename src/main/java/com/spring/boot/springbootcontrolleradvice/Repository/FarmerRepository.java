package com.spring.boot.springbootcontrolleradvice.Repository;

import com.spring.boot.springbootcontrolleradvice.Model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    Farmer findFarmerById(Integer id);

    List<Farmer> findFarmersByIdIn(Collection<Integer> ids);
}
