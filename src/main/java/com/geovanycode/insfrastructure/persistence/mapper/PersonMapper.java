package com.geovanycode.insfrastructure.persistence.mapper;

import com.geovanycode.domain.model.Person;
import com.geovanycode.insfrastructure.persistence.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toDomain(PersonEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Person(entity.getId(), entity.getName(), entity.getEmail());
    }

    public PersonEntity toEntity(Person domain) {
        if (domain == null) {
            return null;
        }

        if (domain.getId() == null) {
            return new PersonEntity(domain.getName(), domain.getEmail());
        }

        return new PersonEntity(domain.getId(), domain.getName(), domain.getEmail());
    }
}