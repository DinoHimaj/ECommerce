package com.example.ecommerceapp.model.dao;

import com.example.ecommerceapp.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface LocalUserRepository extends CrudRepository<LocalUser, Long> {
}
