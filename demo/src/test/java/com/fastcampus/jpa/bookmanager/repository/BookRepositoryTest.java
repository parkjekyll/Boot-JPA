package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTesT(){
        Book book = new Book();
        book.setName("핑구 달래기");
        book.setAuthor("이횽구");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

}
