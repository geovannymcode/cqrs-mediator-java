package com.geovanycode.application.query.user;

import com.geovanycode.application.dto.PersonDto;
import com.geovanycode.application.query.QueryHandler;
import com.geovanycode.domain.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUsersQueryHandler implements QueryHandler<GetUsersQuery, List<PersonDto>> {
    private final PersonRepository personRepository;

    public GetUsersQueryHandler(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional()
    public List<PersonDto> handle(GetUsersQuery query) {
        return personRepository.findAll().stream()
                .map(user -> new PersonDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
