package com.boxfish.repository;

import com.boxfish.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by LTY on 15/8/13.
 * 自定义Repository
 */
@Repository
@Transactional
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    /*
     *自定义HQL查询
     */
    @Override
    public List<UserEntity> findByUserName(String userName) {
        return this.entityManager.createQuery("select u from UserEntity u where u.userName =?1")
                .setParameter(1, userName)
                .getResultList();
    }
    /*
     *自定义SQL查询
     */
    @Override
    public List findAll() {
        return this.entityManager.createNativeQuery("select *from user").getResultList();
    }

    @Override
    public UserEntity findById(Long id) {
        return entityManager.find(UserEntity.class,id);
    }

    @Override
    public void delete(UserEntity entity) {
        entityManager.remove(entity);
    }

    /*
     *保存实体
     */
    @Override
    public void save(UserEntity entity) throws Exception{
        entityManager.persist(entity);
    }
    /*
     *执行em.merge(person)方法时，容器的工作规则：
     如果此时容器中已经存在一个受容器管理的具有相同ID的person实例，
     容器将会把参数person的内容拷贝进这个受管理的实例，merge()方法
     返回受管理的实例，但参数person仍然是分离的不受管理的。容器在决定Flush时把实例同步到数据库中。
     容器中不存在具有相同ID的person实例。容器根据传进的person参数Copy出一个受容器管理的person实例，
     同时 merge()方法会返回出这个受管理的实例，但参数person仍然是分离的不受管理的。容器在决定Flush时把实例同步到数据库中。
     */
    @Override
    public void update(UserEntity entity) throws Exception {
        entityManager.merge(entity);
    }

}
