package com.lucas.gerenciamento_projetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.gerenciamento_projetos.model.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

}
