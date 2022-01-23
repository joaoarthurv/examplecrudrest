package com.api.examplecrudrest.domain.repository;

import com.api.examplecrudrest.domain.dto.PersonDTO;
import com.api.examplecrudrest.domain.entity.PersonEntity;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Configuration
public class PersonRepositoryImpl implements PersonRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplecrudrest");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void createPerson(PersonDTO personDTO) {
        PersonEntity personEntity = new PersonEntity(personDTO.getName(), personDTO.getAge());

        entityManager.getTransaction().begin();
        entityManager.persist(personEntity);
        entityManager.getTransaction().commit();
    }

    @Override
    public PersonEntity getPerson(Long id) {
        TypedQuery<PersonEntity> findUserByUserId = entityManager.createQuery("SELECT u FROM PersonEntity u Where u.id IN (?1)", PersonEntity.class);
        findUserByUserId.setParameter(1, id);
        return findUserByUserId.getSingleResult();
    }

    @Override
    public PersonEntity updatePerson(PersonDTO personDTO) {
        PersonEntity personEntity = getPerson(personDTO.getId());

        if (personEntity != null) {
            personEntity.setName(personDTO.getName());
            personEntity.setAge(personDTO.getAge());

            entityManager.getTransaction().begin();
            entityManager.persist(personEntity);
            entityManager.getTransaction().commit();
        }
        return personEntity;
    }

    @Override
    public void deletePerson(Long id) {
        TypedQuery<PersonEntity> deleUserById = entityManager.createQuery("DELETE FROM PersonEntity u Where u.id IN (?1)", PersonEntity.class);
        deleUserById.setParameter(1, id);
    }
}
