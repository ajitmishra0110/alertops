package com.ajit.alertops.service;

import com.ajit.alertops.model.Incident;
import com.ajit.alertops.repository.IncidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class IncidentService {

    private final IncidentRepository repo;

    public IncidentService(IncidentRepository repo) {
        this.repo = repo;
    }

    public Incident addIncident(Incident incident) {
        incident.setId(new Random().nextLong(1_000_000_000L));
        return repo.save(incident);
    }

    public List<Incident> getAll() {
        return repo.findAll();
    }

    public long highSeverityCount() {
        return repo.countBySeverityIgnoreCase("HIGH");
    }

    public long totalCount() {
        return repo.count();
    }
}
