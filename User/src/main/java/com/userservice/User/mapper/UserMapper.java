package com.userservice.User.mapper;

import com.userservice.User.dto.UserRequestDTO;
import com.userservice.User.dto.UserResponseDTO;
import com.userservice.User.model.user;

public class UserMapper {
    public static UserResponseDTO toDTO(user User){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(User.getId().toString());
        userResponseDTO.setUsername(User.getUsername());
        userResponseDTO.setEmail(User.getEmail());
        userResponseDTO.setPhoneNumber(String.valueOf(User.getPhoneNumber()));
        return userResponseDTO;
    }
    public static user toModel (UserRequestDTO userRequestDTO){
        user newUser = new user();
        newUser.setUsername(userRequestDTO.getName());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setPhoneNumber(Integer.parseInt(userRequestDTO.getPhonenumber()));
        newUser.setPassword(userRequestDTO.getPassword());
        return newUser;
    }
}
