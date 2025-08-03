package com.geovanycode.application.query.handler;

import com.geovanycode.application.dto.PersonDto;
import com.geovanycode.application.query.GetPersonQuery;
import com.geovanycode.domain.PersonDomainService;
import com.geovanycode.domain.model.Person;
import com.geovanycode.domain.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetPersonQueryHandler implements QueryHandler<GetPersonQuery, List<PersonDto>> {
    private final PersonDomainService personDomainService;

    public GetPersonQueryHandler( PersonDomainService personDomainService) {
        this.personDomainService = personDomainService;
    }

    @Override
    @Transactional()
    public List<PersonDto> handle(GetPersonQuery query) {
        List<Person> person = personDomainService.getAllPeople();
        return person.stream()
                .map(user -> new PersonDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
