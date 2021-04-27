package com.illeanaplanzo.bookstoremanager.service;

import com.illeanaplanzo.bookstoremanager.dto.BookDTO;
import com.illeanaplanzo.bookstoremanager.dto.MessageResponseDTO;
import com.illeanaplanzo.bookstoremanager.entity.Book;
import com.illeanaplanzo.bookstoremanager.mapper.BookMapper;
import com.illeanaplanzo.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findbyId(Long id) {

        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDTO(optionalBook.get());
    }
}
