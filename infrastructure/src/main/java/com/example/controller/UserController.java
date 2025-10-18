package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreateUserUseCase;
import com.example.UserAuthenticateUseCase;
import com.example.dto.request.CreateUserRequest;
import com.example.dto.request.LoginUserRequest;
import com.example.dto.response.BaseResponse;
import com.example.dto.response.LoginUserResponse;
import com.example.mapper.UserMapper;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/auth")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;
    private final UserAuthenticateUseCase userAuthenticateUseCase;
    private final UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper, UserAuthenticateUseCase userAuthenticateUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
        this.userAuthenticateUseCase = userAuthenticateUseCase;
    }

    @PostMapping("/register")
    public BaseResponse<LoginUserResponse> create(@Valid @RequestBody CreateUserRequest request) throws Exception {
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


}
