package com.portfolio.chakru.service;

import com.portfolio.chakru.Exception.PasswordException;
import com.portfolio.chakru.Exception.UserException;
import com.portfolio.chakru.models.Login;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.models.dto.UserDTO;

public interface LoginService {
    public UserDTO validLogin(Login userLogin) throws UserException, PasswordException;
    public UserDTO signUpUser(UserModel user) throws UserException;
}
