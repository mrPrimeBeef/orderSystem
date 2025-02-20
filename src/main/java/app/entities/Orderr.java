package app.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity
public class Orderr {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private LocalDate created;

    @ManyToOne
    private Customer customer;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "order_id")
    private Set<OrderLine> orderLines = new HashSet<>();

    public void addOrderline(OrderLine orderLine){
        if (orderLine != null){
            this.orderLines.add(orderLine);
        }
    }

    @PrePersist
    protected void onCreate() {
        created = LocalDate.now();
    }


}
