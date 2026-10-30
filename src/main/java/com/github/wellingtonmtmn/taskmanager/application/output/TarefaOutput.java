package com.github.wellingtonmtmn.taskmanager.application.output;

import com.github.wellingtonmtmn.taskmanager.domain.Tarefa;

import java.util.Optional;

public record TarefaOutput(String id, String titulo, Optional<String> descricao, String status) {

    public static TarefaOutput from(Tarefa tarefa) {
        return new TarefaOutput(tarefa.getId().id().toString(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus().name()) ;
    }
}
