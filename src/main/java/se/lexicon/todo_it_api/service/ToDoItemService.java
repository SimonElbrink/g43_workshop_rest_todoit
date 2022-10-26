package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.dto.ToDoItemDto;
import se.lexicon.todo_it_api.form.ToDoItemForm;
import java.util.List;

public interface ToDoItemService {

    //Form to

    ToDoItemDto create(ToDoItemForm form);
    void update(ToDoItemForm form,Integer id);
    List<ToDoItemDto> findAll();
    ToDoItemDto findById(Integer id);
    void delete(Integer id);
}
