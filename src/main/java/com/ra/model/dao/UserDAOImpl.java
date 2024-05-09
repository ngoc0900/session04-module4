package com.ra.model.dao;

import com.ra.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            users = session.createQuery("from User ", User.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return users;
    }
}
