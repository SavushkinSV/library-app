package ssv.home.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssv.home.library.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFullName(String fullName);

}
