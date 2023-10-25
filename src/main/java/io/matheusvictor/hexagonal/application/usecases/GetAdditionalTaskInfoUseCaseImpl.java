package io.matheusvictor.hexagonal.application.usecases;

import io.matheusvictor.hexagonal.domain.model.AdditionalTaskInfo;
import io.matheusvictor.hexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import io.matheusvictor.hexagonal.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return this.externalServicePort.getAdditionalTaskInfo(id);
    }
}
