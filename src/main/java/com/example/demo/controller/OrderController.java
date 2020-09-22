package com.example.demo.controller;

import com.example.demo.bean.Book;
import com.example.demo.bean.Order;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @GetMapping
    public @ResponseBody
    List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    public List<Order> saveAll(List<Order> list) {
        orderService.saveAll(list);
        return list;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Order> findById(@PathVariable("id") Integer id) {
        return orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        orderService.deleteById(id);
    }

    @DeleteMapping("/{order}")
    public void delete(Order order) {
        orderService.delete(order);
    }

    @DeleteMapping
    public void deleteAll(List<Order> list) {
        orderService.deleteAll(list);
    }
}
