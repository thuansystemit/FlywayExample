package com.darkness.FlywayExample.controller;

import com.darkness.FlywayExample.dto.BookDto;
import com.darkness.FlywayExample.model.Book;
import com.darkness.FlywayExample.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/book")
public class BookController extends BaseController {

    @Autowired
    private BookServices services;

    @PostMapping
    public ResponseEntity<Long> createBook(@RequestBody @Valid BookDto bookDto) {
        return ResponseEntity.ok(services.createBook(bookDto));
    }

    @GetMapping
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok(services.retrievedBookById(id));
    }
}
