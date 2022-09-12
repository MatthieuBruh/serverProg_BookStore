package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findBooksByIsbn(String isbn);
}
