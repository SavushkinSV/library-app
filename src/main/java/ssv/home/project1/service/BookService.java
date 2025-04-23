package ssv.home.project1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ssv.home.project1.model.Book;
import ssv.home.project1.repository.BookRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
