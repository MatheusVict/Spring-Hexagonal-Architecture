package io.matheusvictor.hexagonal.domain.ports.in;

import io.matheusvictor.hexagonal.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
