package app.dao;

import app.entities.Customer;
import app.entities.Orderr;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer, Integer> {
    private static CustomerDAO instance;

    private CustomerDAO(EntityManagerFactory emf) {
        super(Customer.class, emf);
    }

    public static CustomerDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new CustomerDAO(emf);
        }
        return instance;
    }

    public List<Orderr> findAllOrdersByCustId(int id){
        try(EntityManager em = emf.createEntityManager()){
            String jpql = "SELECT o FROM Orderr o WHERE id=:id";
            TypedQuery query = em.createQuery(jpql,Orderr.class);
            query.setParameter("id",id);
            return query.getResultList();
        }
    }
}