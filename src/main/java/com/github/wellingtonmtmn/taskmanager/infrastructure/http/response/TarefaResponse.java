package com.github.wellingtonmtmn.taskmanager.infrastructure.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TarefaResponse(String id, String title, String descricao, String status) {
    public static TarefaResponse from(TarefaOutput output) {
        return new TarefaResponse(output.id(),
                output.titulo(),
                output.descricao().orElse(null),
                output.status());
    }
}
