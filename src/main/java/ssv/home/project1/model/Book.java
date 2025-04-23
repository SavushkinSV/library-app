package ssv.home.project1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    private String title;

    private String author;

    private Long age;

    public Book(String title, String author, Long age) {
        this.title = title;
        this.author = author;
        this.age = age;
    }
}
