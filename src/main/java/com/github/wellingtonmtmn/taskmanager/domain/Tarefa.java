package com.github.wellingtonmtmn.taskmanager.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.Optional;

@Getter
@Setter
public class Tarefa {
    private TarefaId id;
    private String titulo;
    private Optional<String> descricao;
    private TarefaStatus status;

    public Tarefa(String titulo, Optional<String> descricao) {
        Assert.notNull(titulo, "Titulo must not be null");
        this.id = new TarefaId();
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = TarefaStatus.PENDING;
    }

    public void update(Optional<String> titulo, Optional<String> descricao, Optional<TarefaStatus> status) {
        titulo.ifPresent(this::setTitulo);
        descricao.ifPresent( d -> this.setDescricao(Optional.of(d)));
        status.ifPresent(this::setStatus);
    }
}
