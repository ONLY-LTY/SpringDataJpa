package com.boxfish.repository;

import com.boxfish.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by LTY on 15/8/13.
 */
@Repository
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> findByUserName(String userName) {
        return this.entityManager.createQuery("select u from UserEntity u where u.userName =?1")
                .setParameter(1, userName)
                .getResultList();
    }

    @Override
    public void save(UserEntity entity) {
        entityManager.persist(entity);
    }

}
