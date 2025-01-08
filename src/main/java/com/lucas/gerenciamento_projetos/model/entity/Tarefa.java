package com.lucas.gerenciamento_projetos.model.entity;

import com.lucas.gerenciamento_projetos.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;
    
    @Enumerated(EnumType.STRING)     /*SALVA O NOME DO ENUM COMO STRING!*/
    private TaskStatus taskStatus;

    @Column(name = "PRIORIDADE", nullable = false)
    private String prioridade;

    @ManyToOne
    @JoinColumn(name = "project_id")  /*Muitas tarefas estão ligada a um projeto */  /*project_id vai ser a foreigh key que referencia a coluna id do projeto. */
    private Projeto projeto;

}
