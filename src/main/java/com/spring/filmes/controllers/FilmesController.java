package com.spring.filmes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller


public class FilmesController {



    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/cadastrar-filme")
    public String cadastrarFilme() {
        return "cadastrar-filme";
    }

    @RequestMapping("/teste")
    public String teste() {
        return "teste";
    }
}
