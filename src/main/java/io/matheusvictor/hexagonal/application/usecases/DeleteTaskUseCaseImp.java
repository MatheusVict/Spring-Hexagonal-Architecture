package io.matheusvictor.hexagonal.application.usecases;

import io.matheusvictor.hexagonal.domain.ports.in.DeleteTaskUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImp implements DeleteTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImp(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public boolean deleteTask(Long id) {
        return this.taskRepositoryPort.deleteById(id);
    }
}
