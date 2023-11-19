package com.example.ecommerceapp.service;

import com.example.ecommerceapp.API.RegistrationBody;
import com.example.ecommerceapp.exception.UserAlreadyExistsException;
import com.example.ecommerceapp.model.LocalUser;
import com.example.ecommerceapp.model.dao.LocalUserRepository;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private LocalUserRepository localUserRepository;
    private Validator validator;

    // Constructor-based dependency injection
    public UserService(LocalUserRepository localUserRepository, Validator validator){

        this.localUserRepository = localUserRepository;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (localUserRepository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent() ||
                localUserRepository.findByEmailIgnoreCase((registrationBody.getEmail())).isPresent()) {
            throw new UserAlreadyExistsException();
        }

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
