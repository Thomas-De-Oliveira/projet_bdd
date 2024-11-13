package com.exo1.exo1.services;

import com.exo1.exo1.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}