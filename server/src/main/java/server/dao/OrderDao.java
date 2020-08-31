package server.dao;

import lib.model.Cars;
import lib.model.Dealership;
import lib.model.User;

import javax.persistence.EntityManager;


public class OrderDao {
    private EntityManager em;

    public OrderDao(EntityManager em){
        this.em = em;
    }

    public void addOrder(Dealership dealership, Cars cars, User user){
        em.persist(dealership);
        em.persist(cars);
        em.persist(user);
    }


}
