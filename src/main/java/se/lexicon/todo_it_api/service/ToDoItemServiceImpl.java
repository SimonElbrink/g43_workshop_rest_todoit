package se.lexicon.todo_it_api.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.todo_it_api.data.TodoItemDAO;
import se.lexicon.todo_it_api.dto.ToDoItemDto;
import se.lexicon.todo_it_api.form.ToDoItemForm;
import se.lexicon.todo_it_api.model.entity.TodoItem;

import java.util.List;

@Service
public class ToDoItemServiceImpl implements ToDoItemService{

    private final TodoItemDAO todoItemDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public ToDoItemServiceImpl(TodoItemDAO todoItemDAO, ModelMapper modelMapper) {
        this.todoItemDAO = todoItemDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public ToDoItemDto create(ToDoItemForm form) {
        TodoItem todoItem =modelMapper.map(form,TodoItem.class);
        TodoItem toDoItemSaved=todoItemDAO.save(todoItem);
        return modelMapper.map(toDoItemSaved, ToDoItemDto.class);
    }

    @Override
    public ToDoItemDto update(ToDoItemForm form, Integer id) {
        if(id==null) throw new IllegalArgumentException("Id is null");
        if (form == null) throw new IllegalArgumentException("Form was null");
        TodoItem todoItem=todoItemDAO.findById(id).orElseThrow(()->new IllegalArgumentException("Id is null"));
        if(todoItem.getTodoId()==id){
            todoItem.setTitle(form.getTitle());
            todoItem.setDescription(form.getDescription());
            todoItem.setDeadLine(form.getDeadLine());
          todoItem=  todoItemDAO.save(todoItem);
        }
        return modelMapper.map(todoItem,ToDoItemDto.class);
    }

    @Override
    public List<ToDoItemDto> findAll() {
        List<TodoItem> todoItemList = todoItemDAO.findAll();
        return modelMapper.map(todoItemList, new TypeToken<List<ToDoItemDto>>() {
        }.getType());
    }

    @Override
    public ToDoItemDto findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("was null");
//Changed NotFoundException to IllegalArgument Exception
        TodoItem foundById = todoItemDAO.findById(id).orElseThrow(()-> new IllegalArgumentException("Not found"));
        return modelMapper.map(foundById, ToDoItemDto.class);
    }

    @Override
    public void delete(Integer id) {
        todoItemDAO.deleteById(id);
    }
}
