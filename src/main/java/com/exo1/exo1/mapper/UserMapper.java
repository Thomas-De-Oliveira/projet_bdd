package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.UserDTO;
import com.exo1.exo1.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);

    User toUserEntity(UserDTO dto);
}
