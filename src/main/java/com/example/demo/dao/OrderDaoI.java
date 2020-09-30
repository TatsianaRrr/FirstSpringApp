package com.example.demo.dao;

import com.example.demo.bean.Book;
import com.example.demo.bean.Order;
import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDaoI extends CrudRepository<Order, Long> {
    List<Order> findByDescription(String description);

    @Query(value = "SELECT `order`.`datetime` FROM order WHERE datetime >= '2020-09-27 00:00:00.0' AND   datetime <  '2020-09-29 00:00:00.0';", nativeQuery = true)
    List<Order> findBetweenDates(Date from, Date to);
}

