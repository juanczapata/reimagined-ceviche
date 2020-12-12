package com.jcczdev.hotel.uam.data.dao.implementation;

import com.jcczdev.hotel.uam.data.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

public abstract class JpaDao implements Dao {
    protected Class entityClass;
    @PersistenceContext
    protected EntityManager entityManager;

    protected JpaDao() {
        ParameterizedType parameterizedType = (ParameterizedType)  getClass().getGenericSuperclass();
        entityClass = (Class) parameterizedType.getActualTypeArguments()[1];
    }

    @Override
    public void persist(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public void remove(Object entity) {
        entityManager.remove(entity);
    }

    @Override
    public Object findById(Object id) {
        return entityManager.find(entityClass, id);
    }
}
