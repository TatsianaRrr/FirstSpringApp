package com.example.demo.service;

import com.example.demo.bean.Book;
import com.example.demo.bean.User;
import com.example.demo.dao.BookDaoI;
import com.example.demo.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookDaoI bookDaoI;

    public List<Book> getAll() {
        List<Book> res = new ArrayList<>();
        bookDaoI.findAll().forEach(res::add);
        return res;
    }

    public Book save(Book book) {
        return bookDaoI.save(book);
    }

    public List<Book> saveAll(List<Book> list) {
        bookDaoI.saveAll(list).forEach(list::add);
        return list;
    }

    public Optional<Book> findById(long id) {
        return bookDaoI.findById(id);
    }

    public boolean existsById(long id) {
        return bookDaoI.existsById(id);
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookDaoI.findAll().forEach(list::add);
        return list;
    }

    public List<Book> findAllById(List<Long> list) {
        List<Book> results = new ArrayList<>();
        list.forEach(id -> findById(id).ifPresent(results::add));
        return results;
    }

    public void deleteById(long id) {
        bookDaoI.deleteById(id);
    }

    public void delete(Book book) {
        bookDaoI.delete(book);
    }

    public void deleteAll(List<Book> list) {
        bookDaoI.deleteAll(list);
    }
    public Book update(long id, Book book) {
        Optional<Book> byId = bookDaoI.findById(id);
        if (byId.isPresent()) {
            book.setIdbook(Math.toIntExact(id));
            return bookDaoI.save(book);
        } else {
            throw new UserException("Can't find book with id: " + id);
        }
    }
}

