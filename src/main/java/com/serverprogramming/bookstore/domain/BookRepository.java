package com.serverprogramming.bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

    /* http://localhost:8080/api/books/search/findByTitle?title=Le%20monde%20s%27effondre */
    List<Book> findByTitle(@Param("title") String title);
}
