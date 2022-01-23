package com.api.examplecrudrest.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private Long age;

    public PersonDTO(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
