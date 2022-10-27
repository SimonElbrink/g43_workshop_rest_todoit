package se.lexicon.todo_it_api.form;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ToDoItemForm {
    private String title;
    private String description;
    private LocalDate deadLine=LocalDate.now();
    private boolean done;
}
