package com.serverprogramming.bookstore;

import com.serverprogramming.bookstore.domain.Book;
import com.serverprogramming.bookstore.domain.BookRepository;
import com.serverprogramming.bookstore.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitle() {
        List<Book> books = repository.findByTitle("Contes");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Contes");
    }

    @Test
    public void create() {
        Book book = new Book("Le meilleur livre", 978032262, "Marcel Proust", 1978, 29.90, new Category("TESTING"));
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void delete() {
        Book book = new Book("Le livre", 978032210, "Marcel Pagnol", 1989, 24.90, new Category("TESTING"));
        repository.save(book);
        long id = book.getId();
        repository.deleteById(id);
        assertThat(repository.findById(id)).isEmpty();
    }
}
