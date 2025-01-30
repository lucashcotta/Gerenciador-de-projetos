package com.lucas.gerenciamento_projetos.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.lucas.gerenciamento_projetos.enums.ProjectStatus;

@Entity
@Getter
@Setter
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "DATA_CRIACAO", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataCriacao;
    
    @Column(name = "STATUS_PROJECT", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;


    @Column(name = "DATA_Termino")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime dataTermino;


    /*MappedBY -> Diz ao JPA que a relação já está mapeada pelo atributo project na classe Tarefa */
    /*casdade -> Caso o projeto sofra alteração, as tarefas relacionadas a ele tambem sofrerão */
    /*orphanRemoval -> Caso o projeto seja excluido, as tarefas relacionadas a ele tambem serão */
    @JsonManagedReference
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas;

}