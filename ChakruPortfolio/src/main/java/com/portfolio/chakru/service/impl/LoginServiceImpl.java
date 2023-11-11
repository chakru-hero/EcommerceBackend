package com.portfolio.chakru.service.impl;

import com.portfolio.chakru.Exception.PasswordException;
import com.portfolio.chakru.Exception.UserException;
import com.portfolio.chakru.config.passwordConfig.PasswordConfig;
import com.portfolio.chakru.config.securityConfig.UserAuthProvider;
import com.portfolio.chakru.models.Login;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.models.dto.UserDTO;
import com.portfolio.chakru.models.mappers.UserMapper;
import com.portfolio.chakru.repo.UserRepo;
import com.portfolio.chakru.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.CharBuffer;
import java.util.Objects;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService {

    private final UserRepo userRepository;
    private final PasswordConfig passwordEncoder;
    private final UserAuthProvider userAuthProvider;
    private final UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(UserRepo userRepository,
                        PasswordConfig passwordEncoder,
                        UserAuthProvider userAuthProvider,
                        UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthProvider = userAuthProvider;
        this.userMapper = userMapper;
    }
    @Override
    public UserDTO validLogin(Login userLogin) throws UserException, PasswordException {
        if (Boolean.FALSE.equals(StringUtils.hasText(userLogin.getUsername()))) {
            throw new UserException("Username not sent for customer");
        }

        if (Boolean.FALSE.equals(StringUtils.hasText(userLogin.getPassword()))) {
            throw new PasswordException("Password not sent for customer");
        }

        UserModel user = userRepository.findUserModelByUsername(userLogin.getUsername());

        if (Objects.isNull(user)) {
            throw new UserException("user not found");
        }
        user.setToken(userAuthProvider.createToken(user));
        userRepository.save(user);
        if (passwordEncoder.passwordEncoder().matches(CharBuffer.wrap(userLogin.getPassword()), user.getPassword())) {
            return userMapper.toUserDTO(user);
        } else {
            throw new UserException("Incorrect Password");
        }
    }
    @Override
    public UserDTO signUpUser(UserModel user) throws UserException {
        if (Boolean.FALSE.equals(validateUserObject(user))) {
            throw new UserException("Invalid User Object");
        }
        UserModel userAlreadyExists = userRepository.findUserModelByUsername(user.getUsername());
        if (Objects.nonNull(userAlreadyExists)) {
            return userMapper.toUserDTO(userAlreadyExists);
        }
        user.setToken(userAuthProvider.createToken(user));
        user.setPassword(passwordEncoder.passwordEncoder().encode(CharBuffer.wrap(user.getPassword())));
        UserModel savedUser = userRepository.save(user);
        return userMapper.toUserDTO(savedUser);
    }

    private Boolean validateUserObject(UserModel user) throws UserException {
        if (Objects.isNull(user)
                || Boolean.FALSE.equals(StringUtils.hasText(user.getEmail()))
                || Boolean.FALSE.equals(StringUtils.hasText(user.getPassword()))
                || Boolean.FALSE.equals(StringUtils.hasText(user.getUsername()))) {
            throw new UserException("User object is not valid");
        }
        return Boolean.TRUE;
    }
}
