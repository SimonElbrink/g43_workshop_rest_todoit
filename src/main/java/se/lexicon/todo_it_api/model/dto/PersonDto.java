package se.lexicon.todo_it_api.model.dto;

import java.time.LocalDate;
import java.util.List;


public class PersonDto {

    private Integer personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<TodoItemDtoSmall> todoItems;

    public PersonDto() {
    }

    public PersonDto(Integer personId, String firstName, String lastName, LocalDate birthDate, List<TodoItemDtoSmall> todoItems) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.todoItems = todoItems;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<TodoItemDtoSmall> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItemDtoSmall> todoItems) {
        this.todoItems = todoItems;
    }
}
