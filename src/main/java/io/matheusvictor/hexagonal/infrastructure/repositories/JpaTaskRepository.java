package io.matheusvictor.hexagonal.infrastructure.repositories;

import io.matheusvictor.hexagonal.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
