package com.github.wellingtonmtmn.taskmanager.infrastructure.http;

import com.github.wellingtonmtmn.taskmanager.application.*;
import com.github.wellingtonmtmn.taskmanager.domain.TarefaId;
import com.github.wellingtonmtmn.taskmanager.infrastructure.http.request.CriarTarefaRequest;
import com.github.wellingtonmtmn.taskmanager.infrastructure.http.request.UpdateTarefaRequest;
import com.github.wellingtonmtmn.taskmanager.infrastructure.http.response.TarefaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final CriarTarefaUseCase criarTarefaUseCase;
    private final GetTarefaUseCase getTarefaUseCase;
    private final GetTarefaByIdUseCase getTarefaByIdUseCase;
    private final DeleteTarefaUseCase deleteTarefaUseCase;
    private final UpdateTarefaUseCase updateTarefaUseCase;

    public TarefaController(CriarTarefaUseCase criarTarefaUseCase, GetTarefaUseCase getTarefaUseCase,
                            GetTarefaByIdUseCase getTarefaByIdUseCase, DeleteTarefaUseCase deleteTarefaUseCase,
                            UpdateTarefaUseCase updateTarefaUseCase) {
        this.criarTarefaUseCase = criarTarefaUseCase;
        this.getTarefaUseCase = getTarefaUseCase;
        this.getTarefaByIdUseCase = getTarefaByIdUseCase;
        this.deleteTarefaUseCase = deleteTarefaUseCase;
        this.updateTarefaUseCase = updateTarefaUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TarefaResponse create(@RequestBody @Valid CriarTarefaRequest request) {
        var input = request.toInput();
        var output = criarTarefaUseCase.executar(input);
        return TarefaResponse.from(output);
    }

    @GetMapping
    List<TarefaResponse> list() {
        return getTarefaUseCase.executar().stream().map(TarefaResponse::from).toList();
    }

    @GetMapping("/{id}")
    TarefaResponse read(@PathVariable UUID id) {
        var output = getTarefaByIdUseCase.execute(new TarefaId(id));
        return TarefaResponse.from(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        deleteTarefaUseCase.execute(new TarefaId(id));
    }

    @PatchMapping("/{id}")
    TarefaResponse update(@PathVariable UUID id, @RequestBody UpdateTarefaRequest request) {
        var input = request.toInput();
        var output = updateTarefaUseCase.execute(new TarefaId(id), input);
        return TarefaResponse.from(output);
    }
}
