package com.illeanaplanzo.bookstoremanager.repository;

import com.illeanaplanzo.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
