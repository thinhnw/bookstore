package com.bookstore.dao;
import com.bookstore.entity.UsersEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<UsersEntity> implements GenericDAO<UsersEntity> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public UsersEntity create(UsersEntity usersEntity) {
        return super.create(usersEntity);
    }

    @Override
    public UsersEntity update(UsersEntity usersEntity) {
        return super.update(usersEntity);
    }

    @Override
    public UsersEntity get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<UsersEntity> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

}
