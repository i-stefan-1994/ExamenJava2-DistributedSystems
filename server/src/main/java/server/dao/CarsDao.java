package server.dao;

import lib.model.Cars;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CarsDao {

    private EntityManager em;

    public CarsDao(EntityManager em){
        this.em = em;
    }


    public List<Cars> getCars(){

        String sql = "SELECT c FROM Cars c";
        TypedQuery<Cars> query = em.createQuery(sql, Cars.class);
        return query.getResultList();
    }



}
