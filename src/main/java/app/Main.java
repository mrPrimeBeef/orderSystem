package app;

import app.config.HibernateConfig;
import app.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        try (EntityManager em = emf.createEntityManager()) {

            em.getTransaction().begin();
            em.persist(new Customer("John Doe", "john@doe.com"));
            em.getTransaction().commit();

        }

        emf.close();
    }
}