package com.api.examplecrudrest.domain.repository;

import com.api.examplecrudrest.domain.dto.UserDTO;
import com.api.examplecrudrest.domain.entity.PersonEntity;
import com.api.examplecrudrest.domain.entity.UserEntity;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Configuration
public class UserRepositoryImpl implements UserRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("examplecrudrest");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO.getUserEmail(), userDTO.getPassword(),
                new PersonEntity(userDTO.getPersonInfo().getName(), userDTO.getPersonInfo().getAge()));

        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();
    }

    @Override
    public UserEntity getUser(String email) {
        TypedQuery<UserEntity> findUserByEmail = entityManager.createQuery("SELECT u FROM UserEntity u Where u.userEmail IN (?1)", UserEntity.class);
        findUserByEmail.setParameter(1, email);
        return findUserByEmail.getSingleResult();
    }

    @Override
    public UserEntity updateUser(UserDTO userDTO, String email) {
        UserEntity userEntity = getUser(email);

        if (userEntity != null) {
            userEntity.setUserEmail(userDTO.getUserEmail());
            userEntity.setPassword(userDTO.getPassword());

            entityManager.getTransaction().begin();
            entityManager.persist(userEntity);
            entityManager.getTransaction().commit();
        }
        return userEntity;
    }

    @Override
    public void deleteUser(String email) {
        UserEntity userEntity = getUser(email);

        if (userEntity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(userEntity);
            entityManager.remove(userEntity.getPersonEntity());
            entityManager.getTransaction().commit();
        }
    }
}
