package com.example.bookStore.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {

    }

    @Test
    void sellBook(){
        Book book= new Book();
        book.setQuantity(10);

        book.sellBook(5);
        assertEquals(5,book.getQuantity());
        assertThrows(IllegalArgumentException.class, ()->{
           book.sellBook(100);
        });
    }
}