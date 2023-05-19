package com.REG.MTNSIMCARD.Service;

import com.REG.MTNSIMCARD.Models.UserModel;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.LinkedList;
import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    List<UserModel> listUsers();
    UserModel findUserById(int code);
    UserModel findUserByUsername(UserModel user);
    UserModel updateUser(UserModel user);
    void deleteUser(int code);
}
