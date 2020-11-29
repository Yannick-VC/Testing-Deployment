package com.serverprogramming.bookstore.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

    //TRANS_TEST
    //@Query("SELECT name FROM Category")
    //Collection<Category> findAllCategory ();
}
