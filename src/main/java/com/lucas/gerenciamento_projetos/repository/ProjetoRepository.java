package com.lucas.gerenciamento_projetos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.gerenciamento_projetos.enums.ProjectStatus;
import com.lucas.gerenciamento_projetos.model.entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    List<Projeto> findByProjectStatus(ProjectStatus projectStatus);
}
