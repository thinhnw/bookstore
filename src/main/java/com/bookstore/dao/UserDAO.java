package com.bookstore.dao;
import com.bookstore.entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends JpaDAO<UsersEntity> implements GenericDAO<UsersEntity> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public UsersEntity create(UsersEntity u) {

        String encryptedPwd = HashGenerator.generateMD5(u.getPassword());
        u.setPassword(encryptedPwd);
        return super.create(u);
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

    public boolean checkLogin(String email, String password) {

        Map<String, Object> params = new HashMap<>();
        String encryptedPwd = HashGenerator.generateMD5(password);
        params.put("email", email);
        params.put("password", encryptedPwd);
        List<UsersEntity> users = super.findWithNamedQuery("UsersEntity.checkLogin", params);

        if (users.size() == 1) return true;

        return false;
    }
}
