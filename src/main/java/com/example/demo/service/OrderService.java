package com.example.demo.service;

import com.example.demo.bean.Book;
import com.example.demo.bean.Order;
import com.example.demo.dao.OrderDaoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDaoI orderDaoI;

    public List<Order> getAll() {
        List<Order> list = new ArrayList<>();
        orderDaoI.findAll().forEach(list::add);
        return list;
    }

    public Order save(Order order) {
        return orderDaoI.save(order);
    }

    public List<Order> saveAll(List<Order> list) {
        orderDaoI.saveAll(list).forEach(list::add);
        return list;
    }

    public Optional<Order> findById(long id) {
        return orderDaoI.findById(id);
    }

    public boolean existsById(long id) {
        return orderDaoI.existsById(id);
    }

    public List<Order> findAll() {
        List<Order> list = new ArrayList<>();
        orderDaoI.findAll().forEach(list::add);
        return list;
    }

    public List<Order> findAllById(List<Long> list) {
        List<Order> results = new ArrayList<>();
        list.forEach(id -> findById(id).ifPresent(results::add));
        return results;
    }

    public void deleteById(long id) {
        orderDaoI.deleteById(id);
    }

    public void delete(Order order) {
        orderDaoI.delete(order);
    }

    public void deleteAll(List<Order> list) {
        orderDaoI.deleteAll(list);
    }
}

