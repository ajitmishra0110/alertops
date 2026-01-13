package com.ajit.alertops.repository;

import com.ajit.alertops.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidentRepository extends MongoRepository<Incident, Long> {
    long countBySeverityIgnoreCase(String severity);
}
