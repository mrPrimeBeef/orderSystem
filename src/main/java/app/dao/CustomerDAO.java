package app.dao;

import app.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CustomerDAO implements IDAO<Customer, Integer> {
    private static CustomerDAO instance;
    private static EntityManagerFactory emf;


    private CustomerDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CustomerDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            CustomerDAO instance = new CustomerDAO(emf);
        }
        return instance;
    }


    @Override
    public Customer create(Customer customer) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer read(Integer integer) {
        return null;
    }

    @Override
    public List<Customer> readAll() {
        return List.of();
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
