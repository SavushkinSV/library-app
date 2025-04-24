package ssv.home.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

    @NotEmpty(message = "Поле не должно быть пустым")
    private String title;

    @NotEmpty(message = "Поле не должно быть пустым")
    private String author;


    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 1900, message = "Год издания книги должен быть больше, чем 1900.")
    private Long age;

}
