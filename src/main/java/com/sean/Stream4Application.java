package com.sean;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Stream4Application {

    public static void main(String[] args) {
        SpringApplication.run(Stream4Application.class, args);
    }

    @Bean
    public java.util.function.Consumer<KStream<String, String>> process() {
        return input -> input.foreach((k,v) -> {
            System.out.println("Process:\t" + k + " --> " + v);
        });
    }

    @Bean
    public java.util.function.Consumer<KStream<String, String>> anotherProcess() {
        return input -> input.foreach((k,v) -> {
            System.out.println("AnotherProcess\t" + k + " --> " + v);
        });
    }
}
