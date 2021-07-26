package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest{//모든 자바클래스는 오브젝트를 상속 받는다.

    @Test
    void test(){
        User user = new User();
        user.setEmail("email@email.com");
        user.setName("name");

        User user1 = new User("name", "email.email.com", LocalDateTime.now(), LocalDateTime.now());

        User.builder().name("name").email("email@naver.com").build();

        System.out.println(">>>"+user);
    }
}