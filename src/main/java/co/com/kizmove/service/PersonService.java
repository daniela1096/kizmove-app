package co.com.kizmove.service;

import co.com.kizmove.domain.Person;

import java.util.List;

public interface PersonService {

    public List<Person> listPersons();

    public void savePerson(Person person);

    public void deletePerson(Person person);

    public Person findPerson(Person person);
}
