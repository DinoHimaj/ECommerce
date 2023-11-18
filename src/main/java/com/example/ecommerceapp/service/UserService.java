package com.example.ecommerceapp.service;

import com.example.ecommerceapp.API.RegistrationBody;
import com.example.ecommerceapp.model.LocalUser;
import com.example.ecommerceapp.model.dao.LocalUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserRepository localUserRepository;

    // Constructor-based dependency injection
    public UserService(LocalUserRepository localUserRepository){
        this.localUserRepository = localUserRepository;
    }

    public LocalUser registerUser(RegistrationBody registrationBody){
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstname());
        user.setLastName(registrationBody.getLastname());
        user.setUsername(registrationBody.getUsername());
        //TODO:Encrypt passwords
        user.setPassword(registrationBody.getPassword());

        user = localUserRepository.save(user);
        return user;
    }
}
