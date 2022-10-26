package se.lexicon.todo_it_api.dto;

import lombok.*;

import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class PersonDto {
    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
