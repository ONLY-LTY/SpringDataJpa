package com.boxfish.repository;

import com.boxfish.entity.UserEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by LTY on 15/8/13.
 */
public interface UserCustomRepository {

    List findByUserName(String userName);

    List findAll();

    UserEntity findById(Long id);

    void delete(UserEntity entity);

    void save(UserEntity entity) throws Exception;

    void update(UserEntity entity) throws Exception;
}
