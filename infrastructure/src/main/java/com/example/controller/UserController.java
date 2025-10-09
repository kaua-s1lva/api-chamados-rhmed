package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreateUserUseCase;
import com.example.dto.request.CreateUserRequest;
import com.example.dto.response.BaseResponse;
import com.example.mapper.UserMapper;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public BaseResponse<String> createUser(@RequestBody CreateUserRequest request) throws Exception {
        //implementar log
        createUserUseCase.create(userMapper.toUser(request));
        return BaseResponse.<String>builder().success(true).message("Usuário criado com sucesso").build();
    }


}
