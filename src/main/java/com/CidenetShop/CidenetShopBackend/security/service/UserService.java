package com.CidenetShop.CidenetShopBackend.security.service;

import com.CidenetShop.CidenetShopBackend.security.model.User;
import com.CidenetShop.CidenetShopBackend.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByEmail(String emailUser){
        return userRepository.findAllByEmail(emailUser);
    }

    public boolean existsByEmail(String emailUser){
        return userRepository.existsByEmail(emailUser);
    }

    public boolean existsByName(String nameUser){
        return userRepository.existsByName(nameUser);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
