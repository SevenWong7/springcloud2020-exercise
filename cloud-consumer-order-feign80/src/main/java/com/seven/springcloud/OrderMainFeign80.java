package com.seven.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author SevenWong
 * @date 2021-01-13 12:08:08
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderMainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign80.class, args);
    }
}
