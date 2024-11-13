package com.exo1.exo1.services.Implements;

import com.exo1.exo1.dto.UserDTO;
import com.exo1.exo1.mapper.ProjectMapper;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exo1.exo1.repositories.UserRepository;
import com.exo1.exo1.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUserEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());

        if (userDTO.getProjects() != null) {
            existingUser.setProjects(userDTO.getProjects().stream()
                    .map(ProjectMapper.INSTANCE::toProjectEntity)
                    .collect(Collectors.toSet()));
        }

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.INSTANCE.toUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }
}
