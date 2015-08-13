package com.boxfish.repository;

import com.boxfish.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LTY on 15/8/13.
 */

/**
 * CrudRepository  提供了基本的增删改查 我们可以直接继承就好了 如果我们不想暴露一些的借口 可以自定义Repository
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    public abstract List<UserEntity> findByUserName(String userName);


}
