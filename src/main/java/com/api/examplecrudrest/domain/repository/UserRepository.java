package com.api.examplecrudrest.domain.repository;

import com.api.examplecrudrest.domain.dto.UserDTO;
import com.api.examplecrudrest.domain.entity.UserEntity;

public interface UserRepository {
    void createUser(UserDTO userDTO);

    UserEntity getUser(String email);

    UserEntity updateUser(UserDTO userDTO, String email);

    void deleteUser(String email);
}
