package com.authAngular.tutorial.authAngular.mappers;


import com.authAngular.tutorial.authAngular.dto.SignUpDto;
import com.authAngular.tutorial.authAngular.dto.UserDto;
import com.authAngular.tutorial.authAngular.entities.concretes.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password",ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
