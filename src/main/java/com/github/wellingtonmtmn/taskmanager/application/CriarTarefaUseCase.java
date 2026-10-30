package com.github.wellingtonmtmn.taskmanager.application;

import com.github.wellingtonmtmn.taskmanager.application.input.CriarTarefaInput;
import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;
import com.github.wellingtonmtmn.taskmanager.domain.Tarefa;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarTarefaUseCase {
    private final TarefaRepository repository;

    public CriarTarefaUseCase(TarefaRepository repository) {
        this.repository = repository;
    }
    public TarefaOutput executar(CriarTarefaInput input) {
        var tarefa = new Tarefa(input.titulo(), input.descricao());
        var saved = repository.save(tarefa);
        return TarefaOutput.from(saved);
    }
}
