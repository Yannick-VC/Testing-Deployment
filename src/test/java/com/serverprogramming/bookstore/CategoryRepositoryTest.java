package com.serverprogramming.bookstore;

import com.serverprogramming.bookstore.domain.Book;
import com.serverprogramming.bookstore.domain.Category;
import com.serverprogramming.bookstore.domain.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByName() {
        List<Category> categories = repository.findByName("Classics");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Classics");
    }

    @Test
    public void create() {
        Category category = new Category("TESTING");
        repository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void delete() {
        Category category = new Category("TESTING");
        repository.save(category);
        long id = category.getCategoryid();
        repository.deleteById(id);
        assertThat(repository.findById(id)).isEmpty();
    }
}
