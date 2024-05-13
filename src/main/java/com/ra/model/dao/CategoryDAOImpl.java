package com.ra.model.dao;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            categories = session.createQuery("from Category ", Category.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return categories;
    }

    @Override
    public Boolean save(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(category);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Category.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
           session.delete(findById(id));
           session.getTransaction().commit();
           return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }


}
