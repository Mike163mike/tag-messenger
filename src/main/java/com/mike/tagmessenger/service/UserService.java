package com.mike.tagmessenger.service;

import com.mike.tagmessenger.model.User;

public interface UserService {

    void saveUser(User user);

    void deleteUser(String username);
}
