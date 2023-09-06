package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.UserDto;
import com.mike.tagmessenger.dto.UserRegDto;
import com.mike.tagmessenger.mapper.UserMapper;
import com.mike.tagmessenger.model.Role;
import com.mike.tagmessenger.model.User;
import com.mike.tagmessenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserRegDto userRegDto) {
        var newUser = new User();
        newUser.setUsername(userRegDto.username());
        newUser.setPassword(passwordEncoder.encode(userRegDto.password()));
        newUser.setRoles(List.of(Role.ROLE_USER));
        userService.saveUser(newUser);
        return userMapper.map(newUser);
    }

    @Override
    public void deleteUser(String username) {
        userService.deleteUser(username);
    }
}
