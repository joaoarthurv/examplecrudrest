package com.api.examplecrudrest.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "person_entity")
@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long age;

    @OneToOne(mappedBy = "personEntity", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private UserEntity userEntity;

    public PersonEntity( String name, Long age) {
        this.name = name;
        this.age = age;
    }
}
