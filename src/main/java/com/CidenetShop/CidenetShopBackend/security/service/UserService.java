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

    public Optional<User> getById(Long id){
        return userRepository.findAllById(id);
    }

    public Optional<User> getByTokenPassword (String tokenPassword){
        return userRepository.findAllByTokenPassword(tokenPassword);
    }

    public Optional<User> getByTokenActive (String tokenActive){
        return userRepository.findAllByTokenActive(tokenActive);
    }

    public boolean existsByEmail(String emailUser){
        return userRepository.existsByEmail(emailUser);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
