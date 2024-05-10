package com.example.lab520213852.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician technicianID;

    @Column(name = "Status")
    private String status;

    @Column(name = "OpenedDate")
    private String openedDate;

    @Column(name = "ClosedDate")
    private String closedDate;

}