package com.seniorglez.externalService.infra.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class UpperCaseServiceImpl extends UpperCaseServiceGrpc.UpperCaseServiceImplBase {

    @Override
    public void toUpperCase(In.ToUpperCaseRequest request, StreamObserver<In.ToUpperCaseResponse> responseObserver) {
        String upercasedString = request.getInputString().toUpperCase();
        In.ToUpperCaseResponse reply = In.ToUpperCaseResponse
                .newBuilder()
                .setUppercasedString(upercasedString)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
