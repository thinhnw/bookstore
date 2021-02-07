package com.bookstore.dao;
import com.bookstore.entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAO extends JpaDAO<UsersEntity> implements GenericDAO<UsersEntity> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public UsersEntity create(UsersEntity e) {
        return super.create(e);
    }

    @Override
    public UsersEntity update(UsersEntity usersEntity) {
        return super.update(usersEntity);
    }

    @Override
    public UsersEntity get(Object id) {
        return super.find(UsersEntity.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(UsersEntity.class, id);
    }

    @Override
    public List<UsersEntity> listAll() {
        return super.findWithNamedQuery("UsersEntity.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("UsersEntity.countAll");
    }

    public UsersEntity findByEmail(String email) {
        List<UsersEntity> listUsers = super.findWithNamedQuery("UsersEntity.findByEmail", "email", email);

        if (listUsers != null && !listUsers.isEmpty()) {
            return listUsers.get(0);
        }

        return null;
    }

}
