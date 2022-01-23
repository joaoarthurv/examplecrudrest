package com.api.examplecrudrest.application.controller;

import com.api.examplecrudrest.application.service.PersonService;
import com.api.examplecrudrest.domain.dto.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        PersonDTO personDTO = personService.getPerson(id);
        return ResponseEntity.ok().body(personDTO);
    }

    @PutMapping()
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody PersonDTO personDTO) {
        PersonDTO response = personService.updatePerson(personDTO);
        return ResponseEntity.ok().body(response);
    }

}
