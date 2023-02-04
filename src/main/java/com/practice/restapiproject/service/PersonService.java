package com.practice.restapiproject.service;

import com.practice.restapiproject.model.Person;

import java.util.List;

public interface PersonService {
    Person getById(Long id);

    void save(Person person);

    void delete(Long id);

    List<Person> getAll();
}
