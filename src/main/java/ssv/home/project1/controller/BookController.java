package ssv.home.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssv.home.project1.model.Book;
import ssv.home.project1.model.Person;
import ssv.home.project1.service.BookService;
import ssv.home.project1.service.PersonService;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/books/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Long id, @ModelAttribute("person") Person person) {
        Optional<Book> optionalBook = bookService.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            model.addAttribute("book", book);
            Optional<Person> optionalPerson = bookService.findPersonById(book.getId());
            if (optionalPerson.isPresent()) {
                model.addAttribute("owner", optionalPerson.get());
            } else {
                model.addAttribute("people", personService.findAll());
            }

            return "/books/show";
        }

        return "redirect:/books";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("book") @Validated Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/books/new";

        bookService.save(book);
        return "redirect:/books";
    }


}
