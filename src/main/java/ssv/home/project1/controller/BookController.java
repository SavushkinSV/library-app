package ssv.home.project1.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ssv.home.project1.model.Book;
import ssv.home.project1.model.Person;
import ssv.home.project1.service.BookService;
import ssv.home.project1.service.PersonService;

import java.util.Optional;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final PersonService personService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Long id, @ModelAttribute("person") Person person) {
        Optional<Book> optionalBook = bookService.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            model.addAttribute("book", book);

            Optional<Person> optionalPerson = bookService.findPersonById(book.getId());

            if(optionalPerson.isPresent()) {
                model.addAttribute("owner", optionalPerson.get());
            } else {
                model.addAttribute("people", personService.findAll());
            }

            return "/books/show";
        }

        return "redirect:/books";
    }
}
