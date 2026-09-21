package com.javorek.billing_service.config;

import io.grpc.protobuf.services.ProtoReflectionService;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpCReflectionConfig {

    @Bean
    public GrpcServerConfigurer grpcServerConfigurer() {
        return serverBuilder -> {
             serverBuilder
                    .addService(ProtoReflectionService.newInstance());
        };
    }
}
