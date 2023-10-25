package io.matheusvictor.hexagonal.infrastructure.repositories;

import io.matheusvictor.hexagonal.domain.model.Task;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;
import io.matheusvictor.hexagonal.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.jpaTaskRepository.findById(id)
                .map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return this.jpaTaskRepository.findAll()
                .stream()
                .map(TaskEntity::toDomainModel)
                .toList();
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        Optional<Task> taskFound = this.findById(id).map(taskFounded -> {
            taskFounded.setTitle(task.getTitle());
            taskFounded.setDescription(task.getDescription());
            taskFounded.setCompleted(task.isCompleted());
            return taskFounded;
        });
        TaskEntity taskEntity = TaskEntity.fromDomainModel(taskFound.get());
        TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
        return Optional.of(updatedTaskEntity.toDomainModel());

    }

    @Override
    public boolean deleteById(Long id) {
        if (!existsById(id)) {
            return false;
        }
        this.jpaTaskRepository.deleteById(id);
        return true;
    }

    private boolean existsById(Long id) {
        return this.jpaTaskRepository.existsById(id);
    }
}
