package com.illeanaplanzo.bookstoremanager.service;

import com.illeanaplanzo.bookstoremanager.dto.BookDTO;
import com.illeanaplanzo.bookstoremanager.entity.Book;
import com.illeanaplanzo.bookstoremanager.exception.BookNotFoundException;
import com.illeanaplanzo.bookstoremanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.illeanaplanzo.bookstoremanager.utils.BookUtils.createFakeBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {

        Book expectedFoundBook = createFakeBook();

        when(bookRepository.findById((expectedFoundBook.getId()))).thenReturn(Optional.of(expectedFoundBook));

        BookDTO bookDTO = bookService.findbyId(expectedFoundBook.getId());

        assertEquals(expectedFoundBook.getName(), bookDTO.getName());
        assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
        assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName());
    }
}
