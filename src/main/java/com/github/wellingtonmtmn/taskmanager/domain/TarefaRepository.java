package com.github.wellingtonmtmn.taskmanager.domain;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository {
    Tarefa save(Tarefa tarefa);
    List<Tarefa> findAll();
    Optional<Tarefa> findById(TarefaId id);
    void delete(TarefaId id);
}
