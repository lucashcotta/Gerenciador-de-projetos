package com.lucas.gerenciamento_projetos.model.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.gerenciamento_projetos.enums.TaskPriority;
import com.lucas.gerenciamento_projetos.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA_CRIACAO", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataCriacao;
    
    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)     /*SALVA O NOME DO ENUM COMO STRING!*/
    private TaskStatus taskStatus;

    @Column(name = "PRIORIDADE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    
    @ManyToOne
    @JoinColumn(name = "project_id")  /*Muitas tarefas estão ligada a um projeto */  /*project_id vai ser a foreigh key que referencia a coluna id do projeto. */
    @JsonBackReference
    private Projeto projeto;

}
