package se.lexicon.todo_it_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.dto.ToDoItemDto;
import se.lexicon.todo_it_api.form.ToDoItemForm;
import se.lexicon.todo_it_api.service.ToDoItemService;

import java.util.List;

@RestController
public class ToDoItemController {
    private final ToDoItemService toDoItemService;
    @Autowired
    public ToDoItemController(ToDoItemService toDoItemService) {
        this.toDoItemService = toDoItemService;
    }

    @PostMapping("/api/v1/toDoItem")
    public ResponseEntity<ToDoItemDto> create(@RequestBody ToDoItemForm form){
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoItemService.create(form));
    }

//    @PutMapping("/api/v1/toDoItem/{id}")
    @PutMapping("/todo/api/v1/toDoItem/{id}")
    public ResponseEntity<ToDoItemDto> update(@PathVariable("id") Integer id,@RequestBody ToDoItemForm form){
        return ResponseEntity.ok(toDoItemService.update(form,id));
    }

    @GetMapping("/api/v1/toDoItem")
    public ResponseEntity<List<ToDoItemDto>> findAll(){
        return ResponseEntity.ok(toDoItemService.findAll());
    }

    @GetMapping("/api/v1/toDoItem/{id}")
    public ResponseEntity<ToDoItemDto> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(toDoItemService.findById(id));
    }

    @DeleteMapping("/api/v1/toDoItem/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        toDoItemService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
