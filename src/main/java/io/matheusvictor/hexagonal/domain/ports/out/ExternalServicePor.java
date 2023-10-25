package io.matheusvictor.hexagonal.domain.ports.out;

import io.matheusvictor.hexagonal.domain.model.AdditionalTaskInfo;

public interface ExternalServicePor {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
