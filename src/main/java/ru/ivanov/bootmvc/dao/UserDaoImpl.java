package ru.ivanov.bootmvc.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import ru.ivanov.bootmvc.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void add(User user) {
//        entityManager.persist(user);
//    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
//        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user WHERE user.id = :id",User.class)
//                .setParameter("id",id);
//        return query.getSingleResult();
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void removeUserById(long id) {
//        User user = entityManager.find(User.class, id);
//        if (user != null) {
//            entityManager.remove(user);
//        }
        entityManager.createQuery("delete from User where id = :id").setParameter("id",id).executeUpdate();
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
}