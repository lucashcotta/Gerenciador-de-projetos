package com.lucas.gerenciamento_projetos.controller;

import java.time.LocalDateTime;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.gerenciamento_projetos.dto.TarefaDto;
import com.lucas.gerenciamento_projetos.model.entity.Tarefa;
import com.lucas.gerenciamento_projetos.repository.TarefaRepository;


@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping
    public ResponseEntity<TarefaDto> creatTarefa(@RequestBody Tarefa tarefa){
        tarefa.setDataCriacao(LocalDateTime.now());
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        TarefaDto tarefaDto = TarefaDto.convertToTarefaDto(tarefaSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDto> getTarefa(@PathVariable Long id){

        Tarefa getTarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        TarefaDto tarefaDto = TarefaDto.convertToTarefaDto(getTarefa);
        return ResponseEntity.status(HttpStatus.OK).body(tarefaDto);

        //return tarefaRepository.findById(id).map(tarefa -> ResponseEntity.ok(tarefa)).orElseGet(() -> ResponseEntity.notFound().build());
    
    }
    @PostMapping("/{id}/status")
    public ResponseEntity<TarefaDto> attStatus(@PathVariable Long id, @RequestBody Tarefa tarefaAtt ){
        return tarefaRepository.findById(id).map(tarefaExistente -> {
            tarefaExistente.setTaskStatus(tarefaAtt.getTaskStatus());
            Tarefa tarefaSalva = tarefaRepository.save(tarefaExistente);
            return ResponseEntity.ok(TarefaDto.convertToTarefaDto(tarefaSalva));
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> deletaTarefa(@PathVariable long id ){
        if(tarefaRepository.existsById(id)){
            tarefaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }



}
