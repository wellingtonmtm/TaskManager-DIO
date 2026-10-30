package com.github.wellingtonmtmn.taskmanager.application.input;

import com.github.wellingtonmtmn.taskmanager.domain.TarefaStatus;

import java.util.Optional;

public record UpdateTarefaInput(Optional<String> titulo,
                                Optional<String> descricao,
                                Optional<TarefaStatus> status) {


}
