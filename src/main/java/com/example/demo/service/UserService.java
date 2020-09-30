package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDaoI;
import com.example.demo.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDaoI userDaoI;

    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        userDaoI.findAll().forEach(res::add);
        return res;
    }

    public User save(User user) {
        return userDaoI.save(user);
    }

    public List<User> saveAll(List<User> list) {
        userDaoI.saveAll(list).forEach(list::add);
        return list;
    }

    public Optional<User> findById(long id) {
        return userDaoI.findById(id);
    }

    public boolean existsById(long id) {
        return userDaoI.existsById(id);
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDaoI.findAll().forEach(list::add);
        return list;
    }

    public List<User> findAllById(List<Long> list) {
        List<User> results = new ArrayList<>();
        list.forEach(id -> findById(id).ifPresent(results::add));
        return results;
    }

    public void deleteById(long id) {
        userDaoI.deleteById(id);
    }

    public void delete(User user) {
        userDaoI.delete(user);
    }

    public void deleteAll(List<User> list) {
        userDaoI.deleteAll(list);
    }

    public User update(long id, User user) {
        Optional<User> userDaoIById = userDaoI.findById(id);
        if (userDaoIById.isPresent()) {
            user.setIduser(Math.toIntExact(id));
            return userDaoI.save(user);
        } else {
            throw new UserException("Can't find user with id: " + id);
        }
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