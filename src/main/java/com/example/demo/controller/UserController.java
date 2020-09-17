package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody
    List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    public List<User> saveAll(List<User> list) {
        userService.saveAll(list);
        return list;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<User> findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }
/*
    @GetMapping("/{id}")
    public boolean existsById(@PathVariable("id") Long id) {
        return userService.existsById(id);
    }*/
/*
    @GetMapping
    public @ResponseBody List<User> findAll() {
        List<User> list = new ArrayList<>();
        userService.findAll();
        return list;
    }*/
   /* @GetMapping("/{id}")
    public @ResponseBody List<User> findAllById(List<Long> list) {
        return userService.findAllById(list);
    }*/

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/{user}")
    public void delete(User user) {
        userService.delete(user);
    }

    @DeleteMapping
    public void deleteAll(List<User> list) {
        userService.deleteAll(list);
    }
}
