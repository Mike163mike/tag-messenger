package com.mike.tagmessenger.mapper;

import com.mike.tagmessenger.dto.UserDto;
import com.mike.tagmessenger.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto map(User user);
}
