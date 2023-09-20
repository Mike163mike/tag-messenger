package com.mike.tagmessenger.mapper;

import com.mike.tagmessenger.dto.UserDto;
import com.mike.tagmessenger.dto.UserRegDto;
import com.mike.tagmessenger.model.Role;
import com.mike.tagmessenger.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    default UserDto mapFromUserRegDto(UserRegDto userRegDto) {
        return new UserDto(userRegDto.username());
    }

    default User map(UserRegDto userRegDto) {
        var newUser = new User();
        newUser.setUsername(userRegDto.username());
        newUser.setPassword(userRegDto.password());
        newUser.setRoles(List.of(Role.ROLE_USER));
        return newUser;
    }
}
