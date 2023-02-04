package com.practice.restapiproject.service;

import com.practice.restapiproject.model.Person;
import com.practice.restapiproject.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public Person getById(Long id) {
        log.info("PersonServiceImplementation getById {}", id);
        return personRepo.getReferenceById(id);
    }

    @Override
    public void save(Person person) {
        log.info("PersonServiceImplementation save {}", person);
        personRepo.save(person);
    }

    @Override
    public void delete(Long id) {
        log.info("PersonServiceImplementation delete {}", id);
        personRepo.delete(id);
    }

    @Override
    public List<Person> getAll() {
        log.info("PersonServiceImplementation getAll");
        return personRepo.findAll();
    }
}