package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.exception.UserException;
import com.example.demo.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getAll() {
        LOGGER.info("all users");
        return userService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

  /*  @PostMapping(name="/save_all", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> saveAll(@RequestBody List<User> users) {
        return userService.saveAll(users);
    }*/

    @GetMapping("/{userId}")
    public @ResponseBody
    Optional<User> findById(@PathVariable("userId") Integer id) {
        return Optional.ofNullable(userService.findById(id).orElseThrow(UserException::new));
    }

    @PutMapping(value = "/update/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public @ResponseBody User update(@PathVariable("id") Long id, @RequestBody User user) {
        LOGGER.debug("Updating user: {}", user);
        return userService.update(id, user);
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

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping("/{user}")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @DeleteMapping
    public void deleteAll(@RequestParam List<User> list) {
        userService.deleteAll(list);
    }
}
