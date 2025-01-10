package com.lucas.gerenciamento_projetos.dto;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.gerenciamento_projetos.model.entity.Projeto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProjetoDto {

    private String titulo;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;


    public static ProjetoDto convertToProjeto(Projeto projeto){
        ProjetoDto projetoDto = new ProjetoDto();
        projeto.setTitulo(projeto.getTitulo());
        projeto.setDescricao(projeto.getDescricao());
        projeto.setDataCriacao(projeto.getDataCriacao());

        return projetoDto;
    }   

}
