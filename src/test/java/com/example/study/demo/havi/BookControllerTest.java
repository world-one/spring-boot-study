package com.havi;

import com.havi.controller.BookController;
import com.havi.domain.Book;
import com.havi.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {BookController.class})
@ContextConfiguration(classes = SpringBootTest.class)
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

//    @Before
//    public void setup() throws Exception {
//        mvc = webAppContextSetup(bookService).build();
//    }

    @Test
    public void Book_MVC_test() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        mvc.perform(get("/book"))
                .andExpect(status().isOk())
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attribute("bookList", contains(book)));
    }

}
