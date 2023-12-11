package com.railway.grpc;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class GrpcServerConfig {

    private Server grpcServer;

    @Bean
    public Server grpcServer(ApplicationContext applicationContext) throws IOException {
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(50051); // Define the port
        applicationContext.getBeansWithAnnotation(GRpcService.class).forEach((name, bean) -> {
            serverBuilder.addService((BindableService) bean);
        });
        grpcServer = serverBuilder.build().start();
        return grpcServer;
    }

    @PreDestroy
    public void preDestroy() {
        if (grpcServer != null) {
            grpcServer.shutdown();
        }
    }
}