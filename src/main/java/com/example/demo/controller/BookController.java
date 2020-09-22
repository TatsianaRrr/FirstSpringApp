package com.example.demo.controller;

import com.example.demo.bean.Book;
import com.example.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @GetMapping
    public @ResponseBody
    List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    public List<Book> saveAll(List<Book> list) {
        bookService.saveAll(list);
        return list;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<Book> findById(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        bookService.deleteById(id);
    }

    @DeleteMapping("/{book}")
    public void delete(Book book) {
        bookService.delete(book);
    }

    @DeleteMapping
    public void deleteAll(List<Book> list) {
        bookService.deleteAll(list);
    }
}
