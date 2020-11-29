package com.serverprogramming.bookstore;

import com.serverprogramming.bookstore.web.BookController;
import com.serverprogramming.bookstore.web.UserDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookstoreApplicationTests {

    @Autowired
    private BookController controller;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(userDetailService).isNotNull();
    }
}
