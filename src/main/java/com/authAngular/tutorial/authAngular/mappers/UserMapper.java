package com.authAngular.tutorial.authAngular.mappers;


import com.authAngular.tutorial.authAngular.dto.UserDto;
import com.authAngular.tutorial.authAngular.entities.concretes.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
}
