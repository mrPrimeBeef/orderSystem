package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Set<Orderr> orders = new HashSet<>();

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Bi directional
    public void addOrderr(Orderr orderr){
        if (orderr != null){
            this.orders.add(orderr);
            orderr.setCustomer(this);
        }
    }

}