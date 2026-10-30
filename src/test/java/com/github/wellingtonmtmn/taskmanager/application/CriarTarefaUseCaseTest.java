package com.github.wellingtonmtmn.taskmanager.application;


import com.github.wellingtonmtmn.taskmanager.application.input.CriarTarefaInput;
import com.github.wellingtonmtmn.taskmanager.application.output.TarefaOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CriarTarefaUseCaseTest {
    @Autowired
    CriarTarefaUseCase useCase;

    @Test
    void should_create_task_successfully() {
        var input = new CriarTarefaInput("Estudar Java", Optional.of("Finalizar o modo de Records"));

        TarefaOutput output = useCase.executar(input);

        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.titulo());
        assertEquals(Optional.of("Finalizar o modo de Records"), output.descricao());

    }

}