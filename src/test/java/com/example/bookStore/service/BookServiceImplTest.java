package com.example.bookStore.service;

import com.example.bookStore.model.Book;
import com.example.bookStore.repo.BookRepo;
import com.example.bookStore.repo.OpenLibRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class BookServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepo bookRepo;

    @MockBean
    OpenLibRepo openLibRepo;

    @Autowired
    BookService bookService;

   // @Test
    void getBookByName() {
        Book book=new Book();
        when(bookRepo.findByName("test")).thenReturn(book);

        assertEquals(book,bookService.getBookByName("test"));


    }

    //@Test
    void getBookByIsbn(){
        Book book=new Book();
        book.setIsbn("testisbn");
        when(bookRepo.findByIsbn("testisbn")).thenReturn(book);

        assertEquals(book,bookService.getBookByIsbn("testisbn"));


        when(bookRepo.findByIsbn("testisbn")).thenReturn(null);
        when(openLibRepo.findByIsbn("testisbn")).thenReturn(book);
        when(bookRepo.save(book)).thenReturn(book);

        assertEquals(book,bookService.getBookByIsbn("testisbn"));


    }
}