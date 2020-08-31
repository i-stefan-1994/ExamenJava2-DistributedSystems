package server.dao;

import lib.model.Dealership;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DealershipDao {
    private EntityManager em;

    public DealershipDao(EntityManager em){
        this.em = em;
    }

    public List<Dealership> getDealerships(){
        String sql = "SELECT d FROM Dealership d";
        TypedQuery<Dealership> query = em.createQuery(sql, Dealership.class);
        return query.getResultList();
    }


}