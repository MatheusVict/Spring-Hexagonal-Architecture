package io.matheusvictor.hexagonal.domain.ports.in;

public interface DeleteTaskUseCase {
    boolean deleteTask(Long id);
}
