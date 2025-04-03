package com.example.sof3061_01;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sof306101Application {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sof306101Application.class, args);
        System.out.println("running...");
    }

}
