package com.github.wellingtonmtmn.taskmanager.application;

import com.github.wellingtonmtmn.taskmanager.application.input.UpdateTarefaInput;
import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaId;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaNotFoundException;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTarefaUseCase {
    private final TarefaRepository repository;

    public UpdateTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaOutput execute(TarefaId id, UpdateTarefaInput input) {
        var tarefa = repository.findById(id).orElseThrow(() -> new TarefaNotFoundException(id));
        tarefa.update(input.titulo(), input.descricao(),  input.status());
        var updated = repository.save(tarefa);
        return TarefaOutput.from(updated);
    }
}
