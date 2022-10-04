package com.example.spring_boot.dao;


import com.example.spring_boot.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

   @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {

        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(int id, User updateUser) {
        User userToBeUpdated = getUserById(id);

        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
        userToBeUpdated.setAge(updateUser.getAge());
        entityManager.merge(userToBeUpdated);


    }

    public void deleteUser(int id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

      //  entityManager.createQuery("delete from User user where user.id=:id")
      //          .setParameter("id", id)
      //          .executeUpdate();

    }
}
