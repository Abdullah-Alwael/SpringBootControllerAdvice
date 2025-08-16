package com.spring.boot.springbootcontrolleradvice.Repository;

import com.spring.boot.springbootcontrolleradvice.Model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findBuyerById(Integer id);
}
