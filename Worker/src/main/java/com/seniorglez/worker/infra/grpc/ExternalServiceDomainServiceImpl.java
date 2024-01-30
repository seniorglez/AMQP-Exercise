package com.seniorglez.worker.infra.grpc;


import com.seniorglez.worker.domain.ports.ExternalServiceDomainService;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceDomainServiceImpl implements ExternalServiceDomainService {

    private final ExternalServiceClient externalServiceClient;

    public ExternalServiceDomainServiceImpl(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    @Override
    public String toMayus(String msg) {
        return externalServiceClient.toMayus(msg);
    }
}
