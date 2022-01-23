package com.api.examplecrudrest.domain.repository;

import com.api.examplecrudrest.domain.dto.PersonDTO;
import com.api.examplecrudrest.domain.entity.PersonEntity;

public interface PersonRepository {
    void createPerson(PersonDTO personDTO);

    PersonEntity getPerson(Long id);

    PersonEntity updatePerson(PersonDTO personDTO);

    void deletePerson(Long userId);
}
