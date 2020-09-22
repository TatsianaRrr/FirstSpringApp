package com.example.demo.dao;

import com.example.demo.bean.Book;
import com.example.demo.bean.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDaoI extends CrudRepository<Order, Long> {
    List<Order> findByDescription(String description);

}

