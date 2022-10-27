package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.model.dto.TodoItemDto;
import se.lexicon.todo_it_api.model.forms.TodoItemForm;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemService {

    TodoItemDto create(TodoItemForm form);
    TodoItemDto findById(Integer id);
    List<TodoItemDto> findAll();
    List<TodoItemDto> findAllUnassigned();
    List<TodoItemDto> findAllByPersonId(Integer personId);
    List<TodoItemDto> findByDoneStatus(Boolean doneStatus);
    List<TodoItemDto> findByDeadlineBetween(LocalDate start, LocalDate end);
    List<TodoItemDto> findByDeadlineBefore(LocalDate localDate);
    List<TodoItemDto> findByDeadlineAfter(LocalDate localDate);
    List<TodoItemDto> findByTitle(String title);
    List<TodoItemDto> findAllUnfinishedAndOverdue();
    TodoItemDto update(Integer id, TodoItemForm form);
    boolean delete(Integer id);


}
