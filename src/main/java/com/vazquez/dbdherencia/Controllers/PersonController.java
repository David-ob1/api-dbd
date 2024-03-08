package com.vazquez.dbdherencia.Controllers;

import com.vazquez.dbdherencia.DTO.NewPerson;
import com.vazquez.dbdherencia.DTO.PersonDTO;
import com.vazquez.dbdherencia.Models.Person;
import com.vazquez.dbdherencia.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("")
    public ResponseEntity<String> registerPerson(@RequestBody NewPerson newPerson){

        Person person = new Person(newPerson.name(), newPerson.email(), newPerson.password());
        personRepository.save(person);

        return new ResponseEntity<>("Todo salio bien", HttpStatus.CREATED);

    }


    @GetMapping("")
    public List<Person> getAll(){return personRepository.findAll();}

    @GetMapping("/current")
    public PersonDTO getAll(Authentication authentication){
        return new PersonDTO(personRepository.findByEmail(authentication.getName()));
    }

}
