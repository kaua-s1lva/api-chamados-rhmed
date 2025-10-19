package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreateUserUseCase;
import com.example.UpdateUserUseCase;
import com.example.UserAuthenticateUseCase;
import com.example.dto.request.SaveUserRequest;
import com.example.dto.request.LoginUserRequest;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.LoginUserResponse;
import com.example.mapper.UserMapper;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final UserAuthenticateUseCase userAuthenticateUseCase;
    private final UserMapper userMapper;

    public UserController(
        CreateUserUseCase createUserUseCase, 
        UserMapper userMapper, 
        UserAuthenticateUseCase userAuthenticateUseCase,
        UpdateUserUseCase updateUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.userAuthenticateUseCase = userAuthenticateUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @PostMapping("/register")
    public BaseResponse<LoginUserResponse> create(@Valid @RequestBody SaveUserRequest request) throws Exception {
        //implementar log
        String token = createUserUseCase.create(userMapper.toUser(request));
        return BaseResponse.<LoginUserResponse>builder()
            .success(true)
            .message("Usuário criado com sucesso")
            .result(new LoginUserResponse(token))
            .build();
    }

    @PostMapping("/login")
    public BaseResponse<LoginUserResponse> login(@Valid @RequestBody LoginUserRequest request) throws Exception {
        //implementar log
        String token = userAuthenticateUseCase.authenticate(request.email(), request.password());
        return BaseResponse.<LoginUserResponse>builder()
            .success(true)
            .message("Usuário logado com sucesso")
            .result(new LoginUserResponse(token))
            .build();
    }

    @PutMapping()
    public BaseResponse<String> update(@RequestBody @Valid SaveUserRequest request) {
        updateUserUseCase.update(userMapper.toUser(request));
        return BaseResponse.<String>builder()
            .success(true)
            .message("Usuário atualizado com sucesso")
            .build();
    }
}
