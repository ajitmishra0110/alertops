package com.ajit.alertops;

import com.ajit.alertops.model.Incident;
import com.ajit.alertops.repository.IncidentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class AlertopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertopsApplication.class, args);
    }

    @Bean
    CommandLineRunner testMongo(IncidentRepository repo) {
        return args -> {
            Incident i = new Incident(
                    "startup-test",
                    "HIGH",
                    "Inserted on startup",
                    LocalDateTime.now()
            );
            i.setId(new Random().nextLong(1_000_000_000L));
            repo.save(i);
            System.out.println("Mongo insert test executed");
        };
    }
}
