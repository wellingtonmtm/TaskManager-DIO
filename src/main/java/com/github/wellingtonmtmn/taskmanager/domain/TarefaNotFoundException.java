package com.github.wellingtonmtmn.taskmanager.domain;

public class TarefaNotFoundException extends RuntimeException {
    public TarefaNotFoundException(TarefaId tarefaId) {
        super("Tarefa com o id " + tarefaId + " not found");
    }
}
