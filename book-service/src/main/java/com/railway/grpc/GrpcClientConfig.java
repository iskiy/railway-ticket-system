//package com.railway.grpc;
//
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GrpcClientConfig {
//
//    @Bean
//    public ManagedChannel managedChannel() {
//        return ManagedChannelBuilder.forAddress("train_service", 50051)
//                                    .usePlaintext()
//                                    .build();
//    }
//}