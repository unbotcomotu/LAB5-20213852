package com.example.lab520213852.Controller;


import com.example.lab520213852.Entity.Technician;
import com.example.lab520213852.Repository.TechnicianRepository;
import com.example.lab520213852.Repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class OlaController {

    private final TechnicianRepository technicianRepository;
    private final TicketRepository ticketRepository;

    public OlaController(TechnicianRepository technicianRepository,
                         TicketRepository ticketRepository) {
        this.technicianRepository = technicianRepository;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tecnicos")
    public String tecnicos(Model model){
        model.addAttribute("listaTecnicos",technicianRepository.findAll());
        return "tecnicos";
    }

    @GetMapping("/estadisticas")
    public String estadisticas(Model model){
        model.addAttribute("listaIntervencionesPorSitio",ticketRepository.listaIntervencionesPorSitio());
        return "estadisticas";
    }
    @GetMapping("/registrarTecnico")
    public String tecnicos(@ModelAttribute("tecnico") Technician tecnico, Model model){
        model.addAttribute("tipo","Registrar técnico");
        return "guardarTecnico";
    }
    @GetMapping("/editarTecnico")
    public String tecnicos(@ModelAttribute("tecnico") Technician tecnico,@RequestParam("id")Integer id,Model model){
        Optional<Technician>optTecnico=technicianRepository.findById(id);
        if(optTecnico.isPresent()){
            tecnico=optTecnico.get();
            model.addAttribute("tecnico",tecnico);
            model.addAttribute("tipo","Editar técnico");
            return "guardarTecnico";
        }else {
            return "tecnicos";
        }
    }

    @PostMapping("/guardarTecnico")
    public String guardarTecnico(Model model,RedirectAttributes attr, @ModelAttribute("tecnico") @Valid Technician tecnico, BindingResult bindingResult,@RequestParam("tipo")String tipo){
        if(bindingResult.hasErrors()){
            model.addAttribute("tipo",tipo);
            return "guardarTecnico";
        }else {
            attr.addFlashAttribute("confirmacion",tecnico.getId()==null||tecnico.getId() == 0 ? "Técnico " + tecnico.getFirstName() + " " + tecnico.getLastName() + " creado exitosamente" : "Técnico " + tecnico.getFirstName() + " " + tecnico.getLastName() + " actualizado exitosamente");
            technicianRepository.save(tecnico);
            return "redirect:/tecnicos";
        }
    }

}
