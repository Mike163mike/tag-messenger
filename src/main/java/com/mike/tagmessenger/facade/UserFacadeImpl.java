package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.UserDto;
import com.mike.tagmessenger.dto.UserRegDto;
import com.mike.tagmessenger.mapper.UserMapper;
import com.mike.tagmessenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserRegDto userRegDto) {
        userService.saveUser(userMapper.map(userRegDto));
        return userMapper.mapFromUserRegDto(userRegDto);
    }

    @Override
    public void deleteUser(String username) {
        userService.deleteUser(username);
    }
}
