package ssv.home.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssv.home.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
