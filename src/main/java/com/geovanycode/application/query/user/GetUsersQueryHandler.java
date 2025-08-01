package com.geovanycode.application.query.user;

import com.geovanycode.dto.UserDto;
import com.geovanycode.application.query.QueryHandler;
import com.geovanycode.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetUsersQueryHandler implements QueryHandler<GetUsersQuery, List<UserDto>> {
    private final UserRepository userRepository;

    public GetUsersQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional()
    public List<UserDto> handle(GetUsersQuery query) {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
