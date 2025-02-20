package app.utils;

import app.config.HibernateConfig;
import app.dao.CustomerDAO;
import app.dao.ProductDAO;
import app.entities.Customer;
import app.entities.OrderLine;
import app.entities.Orderr;
import app.entities.Product;
import jakarta.persistence.EntityManagerFactory;

import java.security.PKCS12Attribute;

public class Populator {
    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    CustomerDAO customerDAO = CustomerDAO.getInstance(emf);
    ProductDAO productDAO = ProductDAO.getInstance(emf);

    public void populate() {
        Customer c1 = Customer.builder()
                .name("Test1")
                .email("Test1@gmail.com")
                .build();

        Customer c2 = Customer.builder()
                .name("Test2")
                .email("Test2@gmail.com")
                .build();

        Product p1 = Product.builder()
                .price(10)
                .description(" dirt Cheap")
                .name("Chinatoy").build();

        Product p2 = Product.builder()
                .price(20)
                .description("cheap")
                .name("Chinatoy2").build();

        OrderLine orderLine1 = OrderLine.builder()
                .product(p1)
                .quantity(2)
                .build();

        Orderr order1 = Orderr.builder()
                .build();

        order1.addOrderline(orderLine1);
        c1.addOrderr(order1);

        customerDAO.create(c1);
        customerDAO.create(c2);
    }
}
