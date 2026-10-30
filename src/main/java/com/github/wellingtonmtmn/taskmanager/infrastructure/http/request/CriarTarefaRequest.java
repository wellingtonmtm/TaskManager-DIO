package com.github.wellingtonmtmn.taskmanager.infrastructure.http.request;

import com.github.wellingtonmtmn.taskmanager.application.input.CriarTarefaInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CriarTarefaRequest (
        @NotBlank
        @Size(min = 3, max = 100)
        String titulo,
        Optional<@Size (max = 500) String> descricao) {
    public CriarTarefaInput toInput() {
        return new CriarTarefaInput(titulo, descricao);
    }

}
