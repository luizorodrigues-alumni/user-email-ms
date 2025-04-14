package com.luiz.ms.user.services;

import com.luiz.ms.user.models.UserModel;
import com.luiz.ms.user.producers.UserProducer;
import com.luiz.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserProducer userProducer;
    public UserService(UserRepository repository, UserProducer userProducer){
        this.repository = repository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = repository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
