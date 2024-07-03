package com.phat.e.project.Service;

import com.phat.e.project.Entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getOneUser(String id);
    User createUser(User user);
    User updateUser(String id, User updatedUser);
    boolean deleteUser(String id);
}
