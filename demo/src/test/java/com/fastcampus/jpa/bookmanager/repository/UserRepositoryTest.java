package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    @Transactional
    void crud(){ // create, read, update, delete
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }
    @Test
    void select(){
       /* System.out.println("findByEmail : " + userRepository.findByEmail("pinggu@naver.com"));
        System.out.println("getByEmail : " + userRepository.getByEmail("pinggu@naver.com"));
        System.out.println("readByEmail : " + userRepository.readByEmail("pinggu@naver.com"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("pinggu@naver.com"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("pinggu@naver.com"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("pinggu@naver.com"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("pinggu@naver.com"));
        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("pinggu@naver.com"));
        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("pinggu"));
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("pinggu"));
        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("pinggu"));*/

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("pinggu@naver.com", "pinggu"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("pinggu@naver.com", "dubu"));
        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        //보다 큰 것
        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));

        //크거나 같은 것
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween :" + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
        //System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("pinggu", "hyong")));
        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("ping"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("gu"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("ng"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "ping" + "%"));

    }

    @Test
    void pagingAndSoringTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("pinggu"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("pinggu"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("pinggu"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("pinggu", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("pinggu", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getTotalElements());
    }
    @Test
    void insertAndUpdateTest(){
        User user = new User();

        user.setName("pinggu");
        user.setEmail("pinggu@gmail.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setEmail("pinggggguuuuuu");

        userRepository.save(user2);


    }
    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);
        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);
        System.out.println(userRepository.findRawRecord().get("gender"));
    }
    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("ping@naver.com");
        user.setName("ping");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("ping");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }
    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("ping@naver.com");
        user.setName("ping");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("ping@naver.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("ping");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }
    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("ping-new@naver.com");
        user.setName("ping-new");

        userRepository.save(user);

        user.setName("ping-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

}