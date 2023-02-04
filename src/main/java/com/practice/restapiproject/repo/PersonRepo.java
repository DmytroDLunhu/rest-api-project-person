package com.practice.restapiproject.repo;

import com.practice.restapiproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface helps us to "findOne, findAll" for {@link Person} class.
 */
public interface PersonRepo extends JpaRepository<Person, Long> {
    @Autowired
    void delete(Long id);
}
