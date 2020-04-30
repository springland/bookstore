package com.springland365.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id ;

    @Column
    String title ;

    @Column
    String author ;


}
