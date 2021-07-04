package com.sean;

import org.springframework.cloud.stream.binder.kafka.utils.DlqDestinationResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configs {

    @Bean
    public DlqDestinationResolver dlqDestinationResolver() {
        return (rec, ex) -> {
            if (rec.topic().equals("obj-stream")) {
                System.out.println("<<Sending to : obj-stream-dlq>>");
                return "obj-stream-dlq";
            }
            else {
                System.out.println("<<Sending to : generic-dlq>>");
                return "generic-dlq";
            }
        };
    }
}
