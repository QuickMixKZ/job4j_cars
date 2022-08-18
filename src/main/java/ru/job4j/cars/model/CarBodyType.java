package ru.job4j.cars.model;

import javax.persistence.*;

@Entity
@Table(name = "car_body_type")
public class CarBodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;

}
