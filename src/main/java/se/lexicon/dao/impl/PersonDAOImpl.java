package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDAO;
import se.lexicon.dao.sequencer.PersonSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final List<Person> people;

    //create an object of SingleObject
    private static PersonDAOImpl instance;

    //make the constructor private so that this class cannot be instantiated
    private PersonDAOImpl() {
        people = new ArrayList<>();
    }

    //Get the only object available
    public static PersonDAOImpl getInstance() {
        if (instance == null) instance = new PersonDAOImpl();
        return instance;
    }


    @Override
    public Person persist(Person person) {
        if (person.getId() != 0) throw new IllegalStateException("Invalid state person.id was not 0 or null");
        if (findByEmail(person.getEmail()) != null) {
            throw new IllegalStateException("Email " + person.getEmail() + " is already taken");
        }
        person.setId(PersonSequencer.nextId());
        people.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {

        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {

        for (Person person : people) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return person;
            }
        }
        return null;

    }

    @Override
    public Person findUsername(String username) {
        for (Person person : people) {
            if (person.getCredentials().getUsername().equalsIgnoreCase(username)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    @Override
    public void remove(int id) {
        Person person = findById(id);
        if (person != null) people.remove(person);
    }
}
