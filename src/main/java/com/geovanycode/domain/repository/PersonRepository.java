package com.geovanycode.domain.repository;

import com.geovanycode.domain.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    Person save(Person person);
    Optional<Person> findById(Long id);
    Optional<Person> findByEmail(String email);
    List<Person> findAll();
    void delete(Long id);
}
