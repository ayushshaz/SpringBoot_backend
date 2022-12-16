package com.example.Rest_Backend.service;

import com.example.Rest_Backend.dao.PersonDao;
import com.example.Rest_Backend.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Even this can be component
public class PersonService {
    private final PersonDao personDao;
    public PersonService(@Qualifier("DaoImplementation") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPeople();
    }
}