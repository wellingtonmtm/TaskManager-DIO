package com.github.wellingtonmtmn.taskmanager.infrastructure.repository;

import com.github.wellingtonmtmn.taskmanager.domain.Tarefa;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaId;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTarefaRepository implements TarefaRepository {
    private final Map<TarefaId, Tarefa> storage = new HashMap<>();

    @Override
    public Tarefa save(Tarefa tarefa) {
        storage.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    @Override
    public List<Tarefa> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Tarefa> findById(TarefaId id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void delete(TarefaId id) {
        storage.remove(id);
    }
}
