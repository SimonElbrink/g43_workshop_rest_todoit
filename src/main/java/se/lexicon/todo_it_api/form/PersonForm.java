package se.lexicon.todo_it_api.form;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PersonForm {
   // private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate=LocalDate.now();
}
