package se.lexicon.dao;

import se.lexicon.model.Person;

import java.util.List;


public interface PersonDAO {

  Person persist(Person person);
  Person findById(int id);
  Person findByEmail(String email);
  Person findUsername(String username);
  List<Person> findAll();
  void remove(int id);

}
