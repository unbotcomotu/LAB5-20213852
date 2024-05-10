package com.example.lab520213852.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "LocationID", nullable = false)
    private Integer id;

    @Column(name = "City")
    private String city;

    @Column(name = "Country")
    private String country;

}