package ssv.home.project1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssv.home.project1.model.Book;
import ssv.home.project1.model.Person;
import ssv.home.project1.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PersonService personService;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Person> findPersonById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Long personId = optionalBook.get().getPerson().getId();
            if (personId != null) {
                personService.findById(personId);

            }
        }

        return optionalBook.map(Book::getPerson);
    }
}
