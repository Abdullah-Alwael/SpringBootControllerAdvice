package com.spring.boot.springbootcontrolleradvice.Repository;

import com.spring.boot.springbootcontrolleradvice.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById(Integer id);

    List<Item> findItemsByOrderId(Integer orderId);
}
