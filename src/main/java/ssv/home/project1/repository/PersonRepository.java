package ssv.home.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssv.home.project1.model.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFullName(String fullName);

}
