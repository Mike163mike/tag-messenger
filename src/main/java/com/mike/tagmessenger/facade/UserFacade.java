package com.mike.tagmessenger.facade;

import com.mike.tagmessenger.dto.UserDto;
import com.mike.tagmessenger.dto.UserRegDto;

public interface UserFacade {

    UserDto createUser(UserRegDto userRegDto);

    void deleteUser(String username);
}
