package com.serverprogramming.bookstore;

import com.serverprogramming.bookstore.domain.Category;
import com.serverprogramming.bookstore.domain.User;
import com.serverprogramming.bookstore.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void findByUsername() {
        User user = repository.findByUsername("user");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("user");
    }

    @Test
    public void create() {
        User user = new User("test", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "test@gmail.com", "TEST");
        repository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void delete() {
        User user = new User("test", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "test@gmail.com", "TEST");
        repository.save(user);
        long id = user.getId();
        repository.deleteById(id);
        assertThat(repository.findById(id)).isEmpty();
    }
}
