package com.authAngular.tutorial.authAngular.businness.abstracts;

import com.authAngular.tutorial.authAngular.dto.CredentialsDto;
import com.authAngular.tutorial.authAngular.dto.SignUpDto;
import com.authAngular.tutorial.authAngular.dto.UserDto;

public interface UserService {
    public UserDto register(SignUpDto signUpDto);
    public UserDto login(CredentialsDto credentialsDto);
}
