package com.authAngular.tutorial.authAngular.businness.concretes;

import com.authAngular.tutorial.authAngular.businness.abstracts.UserService;
import com.authAngular.tutorial.authAngular.dataAccess.abstracts.UserDao;
import com.authAngular.tutorial.authAngular.dto.CredentialsDto;
import com.authAngular.tutorial.authAngular.dto.UserDto;
import com.authAngular.tutorial.authAngular.entities.concretes.User;
import com.authAngular.tutorial.authAngular.exceptions.AppException;
import com.authAngular.tutorial.authAngular.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class UserManager implements UserService {


    private UserDao userDao;
    private  PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

   // @Autowired
    public UserManager(UserDao userDao, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userDao=userDao;
        this.passwordEncoder=passwordEncoder;
        this.userMapper=userMapper;
    }

    @Override
    public UserDto login(CredentialsDto credentialsDto) {
        User user = userDao.findByLogin(credentialsDto.login())
                .orElseThrow(()->new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()),
                user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password",HttpStatus.BAD_REQUEST);
    }



}
