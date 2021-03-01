package com.example.bookStore.controller;

import com.example.bookStore.model.Book;
import com.example.bookStore.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Autowired
    BookController bookController;

  //  @Test
    @WithMockUser(username = "test", password = "test", roles = "ADMIN")
    void getBook() throws Exception {
        ObjectMapper objectMapper= new ObjectMapper();

        Book book = new Book();
        when(bookService.getBook(10L)).thenReturn(book);
        assertEquals(book,bookController.getBook(10L));

        Book book2 = new Book();
        System.out.println(objectMapper.writeValueAsString(book2));
        mockMvc.perform(get("/api/v1/book/10")).andDo(print())
                .andExpect(content().string(objectMapper.writeValueAsString(book2)));


    }
}