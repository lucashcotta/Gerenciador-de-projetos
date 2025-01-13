package com.lucas.gerenciamento_projetos.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.gerenciamento_projetos.dto.ProjetoDto;
import com.lucas.gerenciamento_projetos.model.entity.Projeto;
import com.lucas.gerenciamento_projetos.repository.ProjetoRepository;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;



    @PostMapping
    public ResponseEntity<ProjetoDto> creatProject(@RequestBody Projeto projeto){
        projeto.setDataCriacao(LocalDateTime.now());
        //projeto.setDataTermino(LocalDateTime.now());
        Projeto newProjectSaved = projetoRepository.save(projeto);
        ProjetoDto newProjectDto = ProjetoDto.convertToProjeto(newProjectSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProjectDto);
    }

    @GetMapping
    public List<Projeto> getAllProjects(){
        return projetoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjectById(@PathVariable Long id){
         return projetoRepository.findById(id).map(projeto -> ResponseEntity.ok(projeto)).orElseGet(() -> ResponseEntity.notFound().build());
         //return projetoRepository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());  --> OS LAMBDA!!!

        }
        



    }


