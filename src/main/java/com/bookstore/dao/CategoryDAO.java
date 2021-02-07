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
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<CategoryEntity> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public CategoryEntity create(CategoryEntity category) {
        return super.create(category);
    }

    @Override
    public CategoryEntity update(CategoryEntity entity) {
        return super.update(entity);
    }

    @Override
    public CategoryEntity find(Class<CategoryEntity> type, Object id) {
        return super.find(type, id);
    }

    @Override
    public void delete(Class<CategoryEntity> type, Object id) {
        super.delete(type, id);
    }
}
