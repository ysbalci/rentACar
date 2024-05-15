package com.example.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "plate", unique=true)
    private String plate;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "state")
    private int state; //1-Available 2-Rented 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
