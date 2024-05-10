package com.example.lab520213852.Repository;

import com.example.lab520213852.DTO.Pregunta2Dto;
import com.example.lab520213852.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(nativeQuery = true, value = "select s.SiteName as 'Sitio',count(t.TicketID) as 'CantidadIntervenciones' from site s inner join ticket t on s.SiteID=t.SiteID group by s.SiteID")
    List<Pregunta2Dto> listaIntervencionesPorSitio();
}