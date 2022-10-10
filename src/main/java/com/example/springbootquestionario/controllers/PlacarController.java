package com.example.springbootquestionario.controllers;

import com.example.springbootquestionario.services.PlacarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlacarController {

    @Autowired
    PlacarService service;

    @GetMapping("/placar")
    private String mostrarPlacar(Model model) {
        model.addAttribute("placar", service.listarPlacar());

        return "placar";
    }
}
