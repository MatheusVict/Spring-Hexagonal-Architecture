package io.matheusvictor.hexagonal.domain.ports.out;

import io.matheusvictor.hexagonal.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
