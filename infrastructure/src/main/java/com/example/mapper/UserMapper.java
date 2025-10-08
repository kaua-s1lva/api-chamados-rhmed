package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.domain.User;
import com.example.domain.enums.UserRoleEnum;
import com.example.dto.request.CreateUserRequest;
import com.example.entity.UserEntity;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user) {
        return new UserEntity(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            user.getRole(),
            user.getCreatedAt(),
            user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserRequest request) {
        return new User(
            request.name(),
            request.email(),
            request.password(),
            UserRoleEnum.USER
        );
    }
}
