package io.matheusvictor.hexagonal.application.usecases;

import io.matheusvictor.hexagonal.domain.model.Task;
import io.matheusvictor.hexagonal.domain.ports.in.RetrieveTaskUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return this.taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepositoryPort.findAll();
    }
}
