package com.example.Rest_Backend.api;

import com.example.Rest_Backend.model.Person;
import com.example.Rest_Backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController         // It means that this class will expose some end-points
public class PersonController {
    private final PersonService personService;

    @Autowired     // Without autowiring also it works because there is just one component named PersonService
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@NonNull @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable("id") UUID id, @NonNull @RequestBody Person newPerson){
        return personService.updatePerson(id, newPerson);
    }
}