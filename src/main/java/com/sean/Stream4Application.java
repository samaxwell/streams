package com.sean;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

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

    private Random random = new Random();
    @Bean
    public java.util.function.Supplier<Integer> send() {
        return () -> random.nextInt(100);
    }

    @Bean
    public java.util.function.Function<KStream<String, String>, KStream<String, String>> increment() {
        return input -> input.mapValues(i -> {
            return i.concat("-") + random.nextInt(1);
        });
    }
}

