package io.matheusvictor.hexagonal.application.services;

import io.matheusvictor.hexagonal.domain.model.AdditionalTaskInfo;
import io.matheusvictor.hexagonal.domain.model.Task;
import io.matheusvictor.hexagonal.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements
        CreateTaskUseCase,
        RetrieveTaskUseCase,
        UpdateTaskUseCase,
        DeleteTaskUseCase,
        GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(
            CreateTaskUseCase createTaskUseCase,
            RetrieveTaskUseCase retrieveTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return this.createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return this.deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return this.retrieveTaskUseCase.getTask(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return this.updateTaskUseCase.updateTask(id, task);
    }
}
