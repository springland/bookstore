package com.springland365.bookstore.repo;

import com.springland365.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Book store
public interface IBookRepo extends JpaRepository<Book,Long > {

    List<Book> findByTitle(String name);
}
