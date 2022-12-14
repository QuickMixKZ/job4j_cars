package ru.job4j.cars.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private byte[] photo;
    private boolean sold;
    private LocalDateTime created;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne(cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Person author;

}
