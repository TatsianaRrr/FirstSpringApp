package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDaoI extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    @Query(value = "SELECT USER s WHERE s.name =?", nativeQuery = true)
    List<User> findBetweenId(int name, int endName);

}

