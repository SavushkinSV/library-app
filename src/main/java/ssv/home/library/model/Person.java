package ssv.home.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 50, message = "Значение поля Ф.И.О. лежит в диапазоне 2..50 символов")
    private String fullName;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private Long yearOfBirth;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Book> books;
}
