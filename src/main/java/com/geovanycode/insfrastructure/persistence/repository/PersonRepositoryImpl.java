package com.geovanycode.insfrastructure.persistence.repository;

import com.geovanycode.domain.model.Person;
import com.geovanycode.domain.repository.PersonRepository;
import com.geovanycode.insfrastructure.persistence.entity.PersonEntity;
import com.geovanycode.insfrastructure.persistence.mapper.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
    public class PersonRepositoryImpl implements PersonRepository {
        private final JpaPersonRepository jpaRepository;
        private final PersonMapper mapper;

        public PersonRepositoryImpl(JpaPersonRepository jpaRepository, PersonMapper mapper) {
            this.jpaRepository = jpaRepository;
            this.mapper = mapper;
        }

        @Override
        public Person save(Person person) {
            PersonEntity entity = mapper.toEntity(person);
            PersonEntity savedEntity = jpaRepository.save(entity);
            return mapper.toDomain(savedEntity);
        }

        @Override
        public Optional<Person> findById(Long id) {
            return jpaRepository.findById(id)
                    .map(mapper::toDomain);
        }

        @Override
        public Optional<Person> findByEmail(String email) {
            return jpaRepository.findByEmail(email)
                    .map(mapper::toDomain);
        }

        @Override
        public List<Person> findAll() {
            return jpaRepository.findAll()
                    .stream()
                    .map(mapper::toDomain)
                    .collect(Collectors.toList());
        }

        @Override
        public void delete(Long id) {
            jpaRepository.deleteById(id);
        }
}
