package com.example.bookStore.repo;

import com.example.bookStore.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepoTest {

    @Autowired
    UserRepo userRepo;

    @Test
    void findUserByUsername() {
        User user= userRepo.findUserByUsername("mock");
        assertEquals("Yavor", user.getName());
    }
}