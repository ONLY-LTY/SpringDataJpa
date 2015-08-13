package com.boxfish.repository;

import com.boxfish.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LTY on 15/8/13.
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    public abstract UserEntity findByUserName(String userName);
}
