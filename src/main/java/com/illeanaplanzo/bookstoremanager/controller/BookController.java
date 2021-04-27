package com.illeanaplanzo.bookstoremanager.controller;

import com.illeanaplanzo.bookstoremanager.dto.BookDTO;
import com.illeanaplanzo.bookstoremanager.dto.MessageResponseDTO;
import com.illeanaplanzo.bookstoremanager.exception.BookNotFoundException;
import com.illeanaplanzo.bookstoremanager.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
@Api(value = "Bookstore Manager API")
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create a new book.")
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Search a book.")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findbyId(id);
    }
}
