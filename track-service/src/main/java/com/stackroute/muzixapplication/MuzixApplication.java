package com.stackroute.muzixapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MuzixApplication {


        public static void main(String[] args) {

            SpringApplication.run(MuzixApplication.class, args);
        }

    }

