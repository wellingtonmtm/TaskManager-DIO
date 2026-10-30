package com.github.wellingtonmtmn.taskmanager.application;

import com.github.wellingtonmtmn.taskmanager.domain.TarefaId;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaNotFoundException;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTarefaUseCase {
    private final TarefaRepository repository;

    public DeleteTarefaUseCase (TarefaRepository repository) {
        this.repository = repository;
    }

    public void execute(TarefaId tarefaId) {
       if (repository.findById(tarefaId).isEmpty()) {
           throw new TarefaNotFoundException(tarefaId);
       }

       repository.delete(tarefaId);
    }
}
