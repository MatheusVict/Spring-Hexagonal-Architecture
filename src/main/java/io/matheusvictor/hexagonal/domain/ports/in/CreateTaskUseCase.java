package io.matheusvictor.hexagonal.domain.ports.in;

import io.matheusvictor.hexagonal.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
