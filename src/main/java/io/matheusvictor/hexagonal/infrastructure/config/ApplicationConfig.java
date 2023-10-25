package io.matheusvictor.hexagonal.infrastructure.config;

import io.matheusvictor.hexagonal.application.services.TaskService;
import io.matheusvictor.hexagonal.application.usecases.*;
import io.matheusvictor.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.ExternalServicePort;
import io.matheusvictor.hexagonal.domain.ports.out.TaskRepositoryPort;
import io.matheusvictor.hexagonal.infrastructure.adapters.ExternalServiceAdapter;
import io.matheusvictor.hexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    // inject dependencies here, because it's decoupled from framework
    public TaskService taskService(
            TaskRepositoryPort taskRepositoryPort,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase

    ) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImp(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(
            ExternalServicePort externalServicePort
    ) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter(new RestTemplate());
    }
}
