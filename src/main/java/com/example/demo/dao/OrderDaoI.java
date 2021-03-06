package com.example.demo.dao;

import com.example.demo.bean.Book;
import com.example.demo.bean.Order;
import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDaoI extends CrudRepository<Order, Long> {
    List<Order> findByDescription(String description);

    @Query(value = "SELECT * FROM `order` o where o.date_time between :from AND :to", nativeQuery = true)
    List<Order> findBetweenDates(@Param("from") Date from, @Param("to") Date to);
}

