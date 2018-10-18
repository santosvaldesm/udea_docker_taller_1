package com.tarea2.paises_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tarea2.paises_app.repository.PaisRepository;

@Controller
@RequestMapping("/listar")
public class PaisesController {

	@Autowired
    private PaisRepository repository;

    @RequestMapping
    public ModelAndView getSuperheroes() {
        return new ModelAndView("paginaPaises", "listaPaises", repository.findAll());
    }
}