package com.portfolio.chakru.models.mappers.impl;


import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.models.dto.UserDTO;
import com.portfolio.chakru.models.mappers.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO toUserDTO(UserModel user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setToken(user.getToken());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
