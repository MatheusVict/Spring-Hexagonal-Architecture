package io.matheusvictor.hexagonal.application.usecases;

import io.matheusvictor.hexagonal.domain.model.Task;
import io.matheusvictor.hexagonal.domain.ports.in.UpdateTaskUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return this.taskRepositoryPort.update(id, task);
    }
}
