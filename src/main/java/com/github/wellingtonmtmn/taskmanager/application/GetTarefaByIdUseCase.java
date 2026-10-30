package com.github.wellingtonmtmn.taskmanager.application;

import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaId;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaNotFoundException;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTarefaByIdUseCase {
    private final TarefaRepository repository;

    public GetTarefaByIdUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaOutput execute(TarefaId id) {
        return repository.findById(id).map(TarefaOutput::from).orElseThrow(() -> new TarefaNotFoundException(id));
    }
}
