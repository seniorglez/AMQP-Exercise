package com.seniorglez.worker.application.useCase;

import com.seniorglez.worker.application.annotation.Injectable;
import com.seniorglez.worker.domain.ports.ExternalServiceDomainService;

@Injectable
public class ToMayusUseCase {

    final ExternalServiceDomainService externalServiceDomainService;


    public ToMayusUseCase(ExternalServiceDomainService externalServiceDomainService) {
        this.externalServiceDomainService = externalServiceDomainService;
    }

    public String execute(String msg) {
        return externalServiceDomainService.toMayus(msg);
    }
}
