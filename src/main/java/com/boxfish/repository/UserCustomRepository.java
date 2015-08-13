package com.boxfish.repository;

import com.boxfish.entity.UserEntity;

import java.util.List;

/**
 * Created by LTY on 15/8/13.
 */
public interface UserCustomRepository {

    List findByUserName(String userName);

    void save(UserEntity entity) throws Exception;
}
