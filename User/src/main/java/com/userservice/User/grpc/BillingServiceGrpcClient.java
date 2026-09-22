package com.userservice.User.grpc;
import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {

    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub;

    public BillingServiceGrpcClient(
        @Value("${billing.service.address:localhost}") String billingServiceAddress,
        @Value("${billing.service.port:9001}") int billingServicePort
    ) {
        log.info("Initializing BillingServiceGrpcClient with address: {} and port: {}", billingServiceAddress, billingServicePort);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(billingServiceAddress, billingServicePort)
                .usePlaintext()
                .build();

        this.billingServiceBlockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String userId, String name, String email) {
        BillingRequest request = BillingRequest.newBuilder()
                .setPatientId(userId)
                .setName(name)
                .setEmail(email)
                .build();

        BillingResponse response = billingServiceBlockingStub.createBillingAccount(request);
        log.info("Billing account created for user {}: {}", userId, response.getStatus());
        return response;
    }
}
