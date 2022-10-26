package se.lexicon.todo_it_api.service;

import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.form.PersonForm;
import java.util.List;

public interface PersonService {

    PersonDto create(PersonForm form);
    void update(PersonForm form, Integer id);
    List<PersonDto> findAll();
    PersonDto findById(Integer id);
    void delete(Integer id);
}
