package ru.job4j.cars.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String login;
    private String password;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Advert> adverts = new HashSet<>();

    public Account() {
    }

}
