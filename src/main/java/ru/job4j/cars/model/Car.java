package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "car_id", nullable = false, updatable = false)})
    private Set<Person> drivers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private CarBodyType bodyType;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Advert> adverts = new HashSet<>();

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }


}
