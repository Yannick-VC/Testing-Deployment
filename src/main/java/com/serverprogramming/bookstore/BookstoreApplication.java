package com.serverprogramming.bookstore;

import com.serverprogramming.bookstore.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

//TRANS_TEST
@EnableTransactionManagement
public class BookstoreApplication {
    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    /** https://github.com/Raphael77777/BookstoreSpringTraining.git */
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner studentDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        return (args) -> {

            log.info("save a couple of categories");

            categoryRepository.save(new Category("Classics"));
            categoryRepository.save(new Category("Fantasy"));
            categoryRepository.save(new Category("Horror"));
            categoryRepository.save(new Category("Fiction"));


            log.info("save a couple of students");

            bookRepository.save(new Book("Le monde s\'effondre", 978032257, "Chinua Achebe", 1958, 20.90, categoryRepository.findByName("Classics").get(0) ));
            bookRepository.save(new Book("Contes", 658032258, "Hans Christian Andersen", 1837, 16.50, categoryRepository.findByName("Fantasy").get(0) ));
            bookRepository.save(new Book("Orgueil et Préjugés", 125032269, "Jane Austen", 1813, 26.30, categoryRepository.findByName("Horror").get(0) ));
            bookRepository.save(new Book("Le Père Goriot", 857639871, "Honoré de Balzac", 1835, 18.20, categoryRepository.findByName("Fiction").get(0) ));


            log.info("save a couple of users");
            userRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@gmail.com", "USER"));
            userRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@gmail.com", "ADMIN"));

            log.info("fetch all books");
            for (Book b : bookRepository.findAll()) {
                log.info(b.toString());
            }
        };
    }
}
