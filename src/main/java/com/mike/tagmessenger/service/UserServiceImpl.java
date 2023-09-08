package com.mike.tagmessenger.service;

import com.mike.tagmessenger.exception.AppException;
import com.mike.tagmessenger.model.User;
import com.mike.tagmessenger.repository.UserRepository;
import com.mike.tagmessenger.security.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityContextService securityContextService;

    @Override
    public void saveUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new AppException(String.format("User %s already registered in system ", user.getUsername()),
                    HttpStatus.BAD_REQUEST);
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(String username) {
        var currentUser = securityContextService.getUserName();
        var user = userRepository.findUserByUsername(username);
        if (!currentUser.equals(username)) {
            throw new AppException("User should be deleted only by himself ",
                    HttpStatus.FORBIDDEN);
        } else if (user != null) {
            userRepository.deleteById(user.getId());
        }
    }
}
