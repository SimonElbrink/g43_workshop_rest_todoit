package se.lexicon.todo_it_api.model.forms;

import java.time.LocalDate;

public class TodoItemForm {

    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;

    public TodoItemForm() {
    }

    public TodoItemForm(String title, String description, LocalDate deadLine, boolean done) {
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
