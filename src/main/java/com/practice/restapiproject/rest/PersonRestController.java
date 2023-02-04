package com.practice.restapiproject.rest;

import com.practice.restapiproject.model.Person;
import com.practice.restapiproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/people/")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long personId) {
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person person = this.personService.getById(personId);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> savePerson(@RequestBody @Validated Person person) {
        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.personService.save(person);
        return new ResponseEntity<>(person, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> updatePerson(@RequestBody @Validated Person person, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.personService.save(person);
        return new ResponseEntity<>(person, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        Person customer = this.personService.getById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Person>> getAllCustomers() {
        List<Person> people = this.personService.getAll();

        if (people.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}