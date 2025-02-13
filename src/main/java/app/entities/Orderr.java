package app.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Orderr {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private LocalDate created;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private OrderLine orderLine;
}
