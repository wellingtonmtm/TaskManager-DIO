package com.github.wellingtonmtmn.taskmanager.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record TarefaId(UUID id) {
    public TarefaId {
        Assert.notNull(id, "id must not be null");
    }

    public TarefaId() {
        this(UUID.randomUUID());
    }
}
