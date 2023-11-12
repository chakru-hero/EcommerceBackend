package com.portfolio.chakru.models.mappers;

import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.models.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(UserModel user);

}
