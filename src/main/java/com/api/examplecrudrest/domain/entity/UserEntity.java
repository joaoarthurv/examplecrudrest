package com.api.examplecrudrest.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "user_entity")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userEmail;

    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;

    public UserEntity(String userEmail, String password, PersonEntity personEntity) {
        this.userEmail = userEmail;
        this.password = password;
        this.personEntity = personEntity;
    }
}
