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

    public User toUser(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getRole(),
            entity.getCreateAt(),
            entity.getUpdateAt()
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
/*
 *     LocalDate term,
    TicketPriorityEnum priority,
    User requester,
    TicketStatusEnum status,
    LocalDate createdAt,
    LocalDate updatedAt
 */
    // public User toUser(EditUserRequest request) {
    //     return new User(
    //         request.id(),
    //         request.code(),
    //         request.title(),
    //         request.description(),
    //         request.term(),
    //         request.priority(),
    //         request.requester(),
    //         request.status(),
    //         request.createdAt(),
    //         request.updatedAt()
    //     );
    // }
}
