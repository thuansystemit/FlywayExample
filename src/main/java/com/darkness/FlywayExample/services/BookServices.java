package com.darkness.FlywayExample.services;

import com.darkness.FlywayExample.dto.BookDto;
import com.darkness.FlywayExample.exception.NotFoundException;
import com.darkness.FlywayExample.model.Book;
import com.darkness.FlywayExample.model.BookType;
import com.darkness.FlywayExample.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServices {
    @Autowired
    private BookRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Long createBook(BookDto bookDto) {
        if (!retrieveBookByName(bookDto.getName())) {
            Book book = modelMapper.map(bookDto, Book.class);
            book.setType(BookType.valueOf(bookDto.getType()));
            Book bookNew = repository.saveAndFlush(book);
            return bookNew.getId();
        }
        return 1L;
    }

    private Boolean retrieveBookByName(String name) {
        return repository.findByName(name).isPresent();
    }

    public Book retrievedBookById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Could not found book by given id: " + id));
    }
}
