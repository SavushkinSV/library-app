package ssv.home.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssv.home.project1.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
