package com.api.examplecrudrest.application.service;

import com.api.examplecrudrest.domain.dto.PersonDTO;
import com.api.examplecrudrest.domain.entity.PersonEntity;
import com.api.examplecrudrest.domain.repository.PersonRepository;
import com.api.examplecrudrest.infrastructure.exception.ErrorCodeDescription;
import com.api.examplecrudrest.infrastructure.exception.ExampleCrudRestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO getPerson(Long id) {
        try {
            PersonEntity personEntity = personRepository.getPerson(id);
            if (personEntity == null) {
                throw new NullPointerException();
            }
            return new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getAge());
        } catch (Exception e) {
            log.error("[PersonService] - Error on function getPerson. Id: {}", id);
            throw new ExampleCrudRestException(ErrorCodeDescription.NOT_FOUND_PERSON);
        }
    }

    public PersonDTO updatePerson(PersonDTO personDTO) {
        try {
            PersonEntity personEntity = personRepository.updatePerson(personDTO);
            if (personEntity == null) {
                throw new NullPointerException();
            }
            return new PersonDTO(personEntity.getId(), personEntity.getName(), personEntity.getAge());
        } catch (Exception e) {
            log.error("[PersonService] - Error on function updatePerson. Name: {}", personDTO.getName());
            throw new ExampleCrudRestException(ErrorCodeDescription.UNKNOWN_ERROR);
        }
    }
}
