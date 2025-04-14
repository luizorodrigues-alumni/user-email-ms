package com.luiz.ms.user.controllers;

import com.luiz.ms.user.dtos.UserDTO;
import com.luiz.ms.user.models.UserModel;
import com.luiz.ms.user.repositories.UserRepository;
import com.luiz.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDTO user){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
