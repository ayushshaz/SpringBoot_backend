package com.example.Rest_Backend.service;

import com.example.Rest_Backend.dao.PersonDao;
import com.example.Rest_Backend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // Even this can be @Component
public class PersonService {
    private final PersonDao personDao;
    @Autowired    // Even when autowired removed its working yet
    public PersonService(@Qualifier("DaoMemory") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPersons() {
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){ return personDao.selectPersonById(id); }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }
}