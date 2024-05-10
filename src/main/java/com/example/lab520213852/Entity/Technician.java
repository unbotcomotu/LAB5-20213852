package com.example.lab520213852.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TechnicianID", nullable = false)
    private Integer id;

    @Size(max = 100,min = 3,message = "El nombre puede tener solo de 3 a 100 caracteres")
    @NotNull(message = "Complete el campo")
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @Size(max = 100,min = 3,message = "El apellido puede tener solo de 3 a 100 caracteres")
    @NotNull(message = "Complete el campo")
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @Size(max = 8,min = 8,message = "El DNI es un número y solo puede tener 8 dígitos")
    @NotNull(message = "Complete el campo")
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @Size(max = 9,min = 9,message = "El número de celular es un número y solo puede tener 9 dígitos")
    @NotNull(message = "Complete el campo")
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;

    @NotNull(message = "Complete el campo")
    @Min(value = 1,message = "La edad es un número y positivo")
    @Column(name = "Age", nullable = false)
    private Integer age;

}