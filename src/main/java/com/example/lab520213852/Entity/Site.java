package com.example.lab520213852.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "site")
public class Site {
    @Id
    @Column(name = "SiteID", nullable = false)
    private Integer id;

    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private Location locationID;

    @Column(name = "InstallationDate")
    private LocalDate installationDate;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

}