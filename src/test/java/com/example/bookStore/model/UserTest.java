package com.example.bookStore.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testToString() {
        User user= new User();
        user.setPassword(null);
        assertEquals("User{id=null, name='null', username='null', password=null, enabled=false, role='null'}",user.toString());

        user.setPassword("1234");
        assertEquals("User{id=null, name='null', username='null', password=***, enabled=false, role='null'}",user.toString());
        assertNotEquals("User{id=null, name='null', username='null', password=1234, enabled=false, role='null'}",user.toString());
    }
}