package com.lucas.gerenciamento_projetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.gerenciamento_projetos.repository.TarefaRepository;


@RestController
@RequestMapping("/contato")
public class TarefaController {
    @Autowired
    private TarefaRepository TarefaRepository;



}
