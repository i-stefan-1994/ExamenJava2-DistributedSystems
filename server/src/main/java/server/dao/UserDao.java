package server.dao;

import lib.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private EntityManager em;

    public UserDao(EntityManager em){
        this.em = em;
    }

    public void addUser(User user){
        em.persist(user);
    }

    public List<User> getUsers(){

        String sql = "Select u FROM User u";
        TypedQuery<User> query = em.createQuery(sql, User.class);

        return query.getResultList();
    }



}
