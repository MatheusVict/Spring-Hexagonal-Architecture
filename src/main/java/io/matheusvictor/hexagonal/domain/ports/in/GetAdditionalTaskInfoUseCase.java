package io.matheusvictor.hexagonal.domain.ports.in;

import io.matheusvictor.hexagonal.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
