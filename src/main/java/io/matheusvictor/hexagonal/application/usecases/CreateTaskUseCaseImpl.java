package io.matheusvictor.hexagonal.application.usecases;

import io.matheusvictor.hexagonal.domain.model.Task;
import io.matheusvictor.hexagonal.domain.ports.in.CreateTaskUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepositoryPort.save(task);
    }
}
