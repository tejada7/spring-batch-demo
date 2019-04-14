package com.example.demospringbatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Esta anotación permite la ejecución automática de tareas.
public class DemoSpringBatchApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoSpringBatchApplication.class);
        builder.headless(false).run(args); // This line allows the GUI to pop-up
    }

}