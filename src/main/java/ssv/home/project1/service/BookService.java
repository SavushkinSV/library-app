package ssv.home.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssv.home.project1.model.Book;
import ssv.home.project1.model.Person;
import ssv.home.project1.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Person> findPersonById(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.map(Book::getPerson);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void cleanPersonById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setPerson(null);
            bookRepository.save(book);
        }
    }
}
