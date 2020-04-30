package com.springland365.bookstore.web.controller;

import com.springland365.bookstore.model.Book;
import com.springland365.bookstore.repo.IBookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/bookstore")
public class BookStoreController {

    Logger logger = LoggerFactory.getLogger(BookStoreController.class);
    @Autowired
    IBookRepo bookRepo;
    @GetMapping("/")
    public String landingPage(Model model)
    {
       return "index";
    }

    @GetMapping("/listbooks")
    public String getBooks(Model model )
    {

        logger.info("getBooks");

        List<Book> books = this.bookRepo.findAll();

        model.addAttribute("books" , books);
        return "listbooks";
    }


    @GetMapping("/addbook")
    public String addBook(Model  model)
    {
        model.addAttribute("book" , new Book());
        return "addbook";
    }

    @PostMapping("/createbook")
    public String createBook(@ModelAttribute("book") Book book)
    {

        logger.info(book.toString());
        this.bookRepo.save(book);
        logger.info("Saved " + book);
        return "listbooks";
    }


}
