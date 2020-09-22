package com.example.demo.dao;

import com.example.demo.bean.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDaoI extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

}

