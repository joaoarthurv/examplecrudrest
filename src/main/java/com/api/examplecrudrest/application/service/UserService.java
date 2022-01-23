package com.api.examplecrudrest.application.service;

import com.api.examplecrudrest.domain.dto.PersonDTO;
import com.api.examplecrudrest.domain.dto.UserDTO;
import com.api.examplecrudrest.domain.entity.PersonEntity;
import com.api.examplecrudrest.domain.entity.UserEntity;
import com.api.examplecrudrest.domain.repository.UserRepository;
import com.api.examplecrudrest.infrastructure.exception.ErrorCodeDescription;
import com.api.examplecrudrest.infrastructure.exception.ExampleCrudRestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO userDTO) {
        userRepository.createUser(userDTO);
    }

    public UserDTO getUser(String email) {
        try {
            UserEntity userEntity = userRepository.getUser(email);
            if (userEntity == null) {
                throw new NullPointerException();
            }
            PersonEntity personEntity = userEntity.getPersonEntity();
            return new UserDTO(userEntity.getUserId(), userEntity.getUserEmail(), userEntity.getPassword(),
                    new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getAge()));
        } catch (Exception e) {
            log.error("[UserService] - Error on function getUser. Email: {}", email);
            throw new ExampleCrudRestException(ErrorCodeDescription.NOT_FOUND_USER);
        }
    }

    public UserDTO updateUser(UserDTO userDTO, String email) {
        try {
            UserEntity userEntity = userRepository.updateUser(userDTO, email);
            if (userEntity == null) {
                throw new NullPointerException();
            }
            PersonEntity personEntity = userEntity.getPersonEntity();
            return new UserDTO(userEntity.getUserId(), userEntity.getUserEmail(), userEntity.getPassword(),
                    new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getAge()));
        } catch (Exception e) {
            log.error("[UserService] - Error on function updateUser. Email: {}", userDTO.getUserEmail());
            throw new ExampleCrudRestException(ErrorCodeDescription.BAD_REQUEST_FOR_UPDATE_USER);
        }
    }

    public void deleteUser(String email) {
        try {
            userRepository.deleteUser(email);
        } catch (Exception e) {
            log.error("[UserService] - Error on function deleteUser. Email: {}", email);
            throw new ExampleCrudRestException(ErrorCodeDescription.BAD_REQUEST_FOR_DELETE_USER);
        }
    }

    public Boolean login(UserDTO userDTO) {
        try {
            UserDTO response = getUser(userDTO.getUserEmail());
            return response.getPassword().equalsIgnoreCase(userDTO.getPassword());
        } catch (Exception e) {
            log.error("[UserService] - Error on function login. User: {} ", userDTO);
            throw new ExampleCrudRestException(ErrorCodeDescription.NOT_FOUND_USER);
        }
    }
}
