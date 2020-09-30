package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDaoI extends CrudRepository<User, Long> {
    List<User> findByName(String name);

}

