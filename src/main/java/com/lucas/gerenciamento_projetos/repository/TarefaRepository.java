package com.lucas.gerenciamento_projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.gerenciamento_projetos.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
