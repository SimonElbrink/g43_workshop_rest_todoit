package se.lexicon.todo_it_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import se.lexicon.todo_it_api.model.entity.Person;

import java.util.List;

public interface PersonDAO extends JpaRepository<Person, Integer> {
    @Query("SELECT p FROM Person p WHERE SIZE(p.todoItems) = 0")
    List<Person> findIdlePeople();
  //  @Modifying()
  //  @Query("UPDATE person Set firstName=:firstName, lastName=:lastName,  birthDate=:birthDate from Person p set where p.personId=:id")
   // Person update(Integer id, Person person );


}
