package com.lucas.gerenciamento_projetos.dto;
import com.lucas.gerenciamento_projetos.enums.TaskStatus;
import com.lucas.gerenciamento_projetos.enums.TaskPriority;
import com.lucas.gerenciamento_projetos.model.entity.Projeto;
import com.lucas.gerenciamento_projetos.model.entity.Tarefa;

import lombok.*;
@Getter
@Setter
public class TarefaDto {
    private String titulo;
    private String descricao;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private Long projectId;
    



    public static TarefaDto convertToTarefaDto(Tarefa tarefa){
        TarefaDto tarefaDto = new TarefaDto();
        tarefaDto.setTitulo(tarefa.getTitulo());
        tarefaDto.setDescricao(tarefa.getDescricao());
        tarefaDto.setTaskPriority(tarefa.getTaskPriority());
        tarefaDto.setTaskStatus(tarefa.getTaskStatus());
        tarefaDto.setProjectId(tarefa.getProjeto().getId());
        return tarefaDto;

    }

}
