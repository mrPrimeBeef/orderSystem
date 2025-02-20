package app.dao;

import app.entities.Customer;
import app.entities.Product;
import jakarta.persistence.EntityManagerFactory;

public class ProductDAO extends AbstractDAO<Product, Integer>{
    private static ProductDAO instance;

    private ProductDAO(EntityManagerFactory emf) {
        super(Product.class, emf);
    }

    public static ProductDAO getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new ProductDAO(emf);
        }
        return instance;
    }
}
