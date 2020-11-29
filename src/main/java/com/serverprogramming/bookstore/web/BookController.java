package com.serverprogramming.bookstore.web;

import com.serverprogramming.bookstore.domain.Book;
import com.serverprogramming.bookstore.domain.BookRepository;
import com.serverprogramming.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //TRANS_TEST
    @Transactional
    @GetMapping("/trans")
    public String trans(Model model){
        bookRepository.save(new Book("TRANS", 978032257, "Chinua Achebe", 1958, 20.90, categoryRepository.findByName("Classics").get(0) ));
        bookRepository.save(new Book("TRANS", 978032257, "Chinua Achebe", 1958, 20.90, categoryRepository.findByName("Classics").get(0) ));
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @GetMapping("/booklist")
    public String booklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookRepository.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    /****************************** REST API ********************************/

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }
}
