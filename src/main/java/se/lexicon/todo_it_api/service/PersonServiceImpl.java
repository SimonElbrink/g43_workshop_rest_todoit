package se.lexicon.todo_it_api.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.lexicon.todo_it_api.data.PersonDAO;
import se.lexicon.todo_it_api.dto.PersonDto;
import se.lexicon.todo_it_api.dto.ToDoItemDto;
import se.lexicon.todo_it_api.form.PersonForm;
import se.lexicon.todo_it_api.model.entity.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements  PersonService{

    private final PersonDAO personDAO;
    private final ModelMapper modelMapper;
    @Autowired
    public PersonServiceImpl(PersonDAO personDAO, ModelMapper modelMapper){
        this.personDAO = personDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonDto create(PersonForm form) {
        Person person =modelMapper.map(form,Person.class);
        Person personSaved=personDAO.save(person);
        return modelMapper.map(personSaved,PersonDto.class);
    }

    @Override
    public void update(PersonForm form, Integer id) {
        if(personDAO.existsById(id)){
      //  Person person = modelMapper.map(form, Person.class);
        //if(person.getPersonId()==id){
            // personDAO.save(person);
        personDAO.save(modelMapper.map(form,Person.class));

        }
    }

    @Override
    public List<PersonDto> findAll() {
        List<Person> personList = personDAO.findAll();
        return modelMapper.map(personList, new TypeToken<List<PersonDto>>() {}.getType());
    }

    public PersonDto findById(Integer id){
       Person foundPerson = personDAO.findById(id).orElseThrow(()-> new IllegalArgumentException("Id is null"));
       PersonDto personDto=modelMapper.map(foundPerson,PersonDto.class);
        return personDto;
    }

    @Override
    public void delete(Integer id) {
        personDAO.deleteById(id);

    }
}
