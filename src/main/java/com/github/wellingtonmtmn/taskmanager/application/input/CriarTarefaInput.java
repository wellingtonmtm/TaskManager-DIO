package com.github.wellingtonmtmn.taskmanager.application.input;

import java.util.Optional;

public record CriarTarefaInput(String titulo, Optional<String> descricao) {
}
