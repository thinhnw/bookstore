package com.bookstore.dao;

import com.bookstore.entity.CategoryEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO extends JpaDAO<CategoryEntity> implements GenericDAO<CategoryEntity> {

    public CategoryDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public CategoryEntity get(Object id) {

        return super.find(CategoryEntity.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(CategoryEntity.class, id);
    }

    @Override
    public List<CategoryEntity> listAll() {
        return super.findWithNamedQuery("CategoryEntity.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("CategoryEntity.countAll");
    }

    @Override
    public CategoryEntity create(CategoryEntity category) {
        return super.create(category);
    }

    @Override
    public CategoryEntity update(CategoryEntity category) {
        return super.update(category);
    }

    @Override
    public CategoryEntity find(Class<CategoryEntity> type, Object id) {
        return super.find(type, id);
    }

    @Override
    public void delete(Class<CategoryEntity> type, Object id) {
        super.delete(type, id);
    }

    public CategoryEntity findByName(String name) {
        List<CategoryEntity> listCtg = super.findWithNamedQuery("CategoryEntity.findByName", "name", name);
        if (listCtg != null && !listCtg.isEmpty()) {
            return listCtg.get(0);
        }
        return null;
    }
}
