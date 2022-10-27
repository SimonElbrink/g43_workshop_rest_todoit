package se.lexicon.todo_it_api.dto;

import lombok.*;
import se.lexicon.todo_it_api.model.entity.Person;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ToDoItemDto {
    private Integer todoId;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person assignee;
}
