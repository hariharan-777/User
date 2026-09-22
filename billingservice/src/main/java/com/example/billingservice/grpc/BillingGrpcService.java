package com.example.billingservice.grpc;

import org.slf4j.Logger;
import org.springframework.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import billing.BillingRequest;
import billing.BillingResponse;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(BillingRequest request, StreamObserver<BillingResponse> responseObserver) {
        log.info("Received request to create billing account for user: patientId={}, name={}, email={}",
                request.getPatientId(), request.getName(), request.getEmail());

        if (request.getPatientId().isBlank()) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("patientId is required to create a billing account")
                    .asRuntimeException());
            return;
        }

        // A real implementation would persist the account; here we generate an account id.
        String accountId = UUID.randomUUID().toString();

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId(accountId)
                .setStatus("ACTIVE")
                .build();

        log.info("Created billing account {} for patient {}", accountId, request.getPatientId());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
