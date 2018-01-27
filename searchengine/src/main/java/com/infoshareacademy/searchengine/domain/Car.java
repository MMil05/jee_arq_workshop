package com.infoshareacademy.searchengine.domain;

import javax.persistence.*;

//@Entity
@NamedQueries({
        @NamedQuery(name = "selectAll",query = "from Car "),
        @NamedQuery(name = "update",query = "update Car set model=:model where model=:modelToUpdate")})

public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long id;

    @Column
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}