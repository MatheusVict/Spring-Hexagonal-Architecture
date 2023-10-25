package io.matheusvictor.hexagonal.domain.ports.in;

import io.matheusvictor.hexagonal.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id,Task task);
}
