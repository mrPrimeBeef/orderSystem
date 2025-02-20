package app;

import app.config.HibernateConfig;
import app.dao.CustomerDAO;
import app.dao.ProductDAO;
import app.entities.Customer;
import app.utils.Populator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        CustomerDAO customerDAO = CustomerDAO.getInstance(emf);
        ProductDAO productDAO = ProductDAO.getInstance(emf);

        Populator pop = new Populator();
        pop.populate();

        System.out.println(customerDAO.findAllOrdersByCustId(1));

    }
}