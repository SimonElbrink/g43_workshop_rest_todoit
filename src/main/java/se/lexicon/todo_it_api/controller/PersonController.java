package se.lexicon.todo_it_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.form.PersonForm;
import se.lexicon.todo_it_api.service.PersonService;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/v1/person")
    public ResponseEntity<PersonDto> create(@RequestBody PersonForm personForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personForm));
    }

    @PutMapping("api/v1/person/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody PersonForm personForm){
        personService.update(personForm, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("api/v1/person")
    public ResponseEntity<List<PersonDto>> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("api/v1/person/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable("id") Integer id ){
        return ResponseEntity.ok(personService.findById(id));
    }

    @DeleteMapping("api/v1/person/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        personService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
