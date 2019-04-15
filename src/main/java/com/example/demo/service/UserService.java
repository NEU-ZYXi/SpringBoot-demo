package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
//    @Transactional: when throwing an error, the transaction will rollback and do not save anyone into database
    public void insertUsers() {
        User user1 = new User();
        User user2 = new User();
        user1.setUsername("qwe");
        user1.setAge(11);
        user2.setUsername("asd");
        user2.setAge(12);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
