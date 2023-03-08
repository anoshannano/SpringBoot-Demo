package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // represent a table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id //How we declare primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand, model, color , registerNumber;
    private int year,price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Owner owner;


}
