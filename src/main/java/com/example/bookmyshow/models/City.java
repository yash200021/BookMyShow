package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    @OneToMany
    private List<Theatre> theaters;
}
/*
1           m
City   --> Theatre --> 1 : m
1           1
 */