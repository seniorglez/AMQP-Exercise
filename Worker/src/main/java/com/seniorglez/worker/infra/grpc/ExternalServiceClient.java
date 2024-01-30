package com.seniorglez.worker.infra.grpc;

import com.seniorglez.externalService.infra.grpc.ExternalService;
import com.seniorglez.externalService.infra.grpc.UpperCaseServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExternalServiceClient {

    private final String HOST = "localhost";
    private final int PORT = 9090;
    private final UpperCaseServiceGrpc.UpperCaseServiceBlockingStub blockingStub;

    public ExternalServiceClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();
        blockingStub = UpperCaseServiceGrpc.newBlockingStub(channel);
    }

    public String toMayus(String msg) {
        ExternalService.ToUpperCaseRequest request = ExternalService.ToUpperCaseRequest.newBuilder().setInputString(msg).build();
        ExternalService.ToUpperCaseResponse response = blockingStub.toUpperCase(request);
        return response.getUppercasedString();
    }
}
