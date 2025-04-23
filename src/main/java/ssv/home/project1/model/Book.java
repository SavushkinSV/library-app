package ssv.home.project1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    private Long personId;

    private String title;

    private String author;

    private Long age;

    public Book(String title, String author, Long age) {
        this.title = title;
        this.author = author;
        this.age = age;
    }
}
