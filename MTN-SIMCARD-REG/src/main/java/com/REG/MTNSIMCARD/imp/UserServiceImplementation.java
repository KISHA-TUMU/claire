package com.REG.MTNSIMCARD.imp;

import com.REG.MTNSIMCARD.Models.UserModel;
import com.REG.MTNSIMCARD.Repository.UserRepository;
import com.REG.MTNSIMCARD.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository repo;
    @Override
    public UserModel saveUser(UserModel user) {
        return repo.save(user);
    }

    @Override
    public List<UserModel> listUsers() {
        return repo.findAll();
    }

    @Override
    public UserModel findUserById(int code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public UserModel findUserByUsername(UserModel user) {
        return repo.findByUsername(user);
    }

    @Override
    public UserModel updateUser(UserModel user) {
        UserModel savedUser = repo.findById(user.getId()).orElse(null);
        if (savedUser!=null){
            UserModel updatedUser = new UserModel();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());

            return repo.save(updatedUser);
        }
        return repo.save(user);
    }

    @Override
    public void deleteUser(int code) {
        UserModel savedUser = repo.findById(code).orElse(null);
        if (savedUser!=null){
            repo.delete(savedUser);
        }

    }
}
