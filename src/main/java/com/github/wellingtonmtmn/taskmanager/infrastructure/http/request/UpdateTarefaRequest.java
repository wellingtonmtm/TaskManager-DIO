package com.github.wellingtonmtmn.taskmanager.infrastructure.http.request;

import com.github.wellingtonmtmn.taskmanager.application.input.UpdateTarefaInput;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaStatus;

import java.util.Optional;

public record UpdateTarefaRequest(
        Optional<String> titulo,
        Optional<String> descricao,
        Optional<String> status
) {
    public UpdateTarefaInput toInput() {
        return new UpdateTarefaInput(titulo, descricao, status.map(TarefaStatus::valueOf));
    }
}
