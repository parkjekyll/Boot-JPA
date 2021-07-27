package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.Publisher;
import com.fastcampus.jpa.bookmanager.domain.Review;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTesT(){
        Book book = new Book();
        book.setName("핑구 달래기");
        book.setAuthorId(1L);
        //book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest(){
        givenBookAndReview();
        User user = userRepository.findByEmail("pinggu@naver.com");
        System.out.println("review:"+user.getReviews());
        System.out.println("book:"+user.getReviews().get(0).getBook());
        System.out.println("publisher:"+user.getReviews().get(0).getBook().getPublisher());
    }
    private void givenBookAndReview(){
        givenReview(givenUser(), givenBook(givenPublisher()));
    }
    private User givenUser(){
        return userRepository.findByEmail("pinggu@naver.com");
    }
    private void givenReview(User user, Book book){
        Review review = new Review();
        review.setTitle("핑구가 짖은 날");
        review.setContent("월월이도다");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
    private Book givenBook(Publisher publisher){
        Book book = new Book();
        book.setName("핑구야 놀자");
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("횽구네");

        return publisherRepository.save(publisher);
    }
}
