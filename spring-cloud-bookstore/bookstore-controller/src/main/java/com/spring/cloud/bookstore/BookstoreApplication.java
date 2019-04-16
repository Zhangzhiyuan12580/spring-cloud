package com.spring.cloud.bookstore;

import com.spring.cloud.basic.dto.UserMsg;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Log4j2
@SpringBootApplication(scanBasePackages = {"com.spring.cloud.bookstore", "com.spring.cloud.basic.feign"})
@EnableDiscoveryClient
@EnableHystrix
@EnableBinding(Sink.class)
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void show(UserMsg userMsg) {
        log.info("receive user msg:{}", userMsg);
    }

}
