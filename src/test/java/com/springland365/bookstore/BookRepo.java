package com.springland365.bookstore;

import com.springland365.bookstore.model.Book;
import com.springland365.bookstore.repo.IBookRepo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {DbConfig.class})
class BookRepo {

    Logger  logger = LoggerFactory.getLogger(BookRepo.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    IBookRepo bookRepo ;
    @Test
    public void testFindAll()
    {
        List<Book> books =  this.bookRepo.findAll();

        books.stream().forEach( t-> logger.info(t.toString()));
       logger.info( this.dataSource.toString());
    }

}
