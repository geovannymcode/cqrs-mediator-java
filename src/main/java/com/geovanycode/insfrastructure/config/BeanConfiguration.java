package com.geovanycode.insfrastructure.config;

import com.geovanycode.domain.PersonDomainService;
import com.geovanycode.domain.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PersonDomainService personDomainService(PersonRepository personRepository) {
        return new PersonDomainService(personRepository);
    }
}
