package com.github.wellingtonmtmn.taskmanager.application;

import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTarefaUseCase {
    private final TarefaRepository repository;

    public GetTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<TarefaOutput> executar() {
        return repository.findAll().stream().map(TarefaOutput::from).toList();
    }
}
