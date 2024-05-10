package com.example.lab520213852.Repository;

import com.example.lab520213852.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}