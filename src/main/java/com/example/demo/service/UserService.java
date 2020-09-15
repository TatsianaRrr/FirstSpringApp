package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDaoI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDaoI userDaoI;

    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        userDaoI.findAll().forEach(res::add);
        return res;
    }
}
   /* public List<User> getAll() {
        List<User> res = new ArrayList<>();
        userDaoI.findAll().forEach(e -> {
            res.add(e);
            logger.error("e {}", e.toString());
        });
        logger.error("res {}", res.toString());
        return res;
    }*/