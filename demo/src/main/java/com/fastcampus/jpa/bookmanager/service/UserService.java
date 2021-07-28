package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@gmail.com");

        entityManager.persist(user);
        //entityManager.detach(user);

        user.setName("newUserAfterPersist"); //특별하게 save 액션 취하지 않았는데도 변경이 일어남. 더티체킹(변경감지)
        entityManager.merge(user);
        /*entityManager.flush();
        entityManager.clear();*/

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

/*        user1.setName("pingggggg");
        entityManager.merge(user1);*/
    }
}
