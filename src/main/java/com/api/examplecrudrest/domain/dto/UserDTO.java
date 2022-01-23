package com.api.examplecrudrest.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String userEmail;
    private String password;
    private PersonDTO personInfo;

    public UserDTO(Long userId, String userEmail, String password, PersonDTO personDTO) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.password = password;
        this.personInfo = personDTO;
    }
}
