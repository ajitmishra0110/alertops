package com.ajit.alertops.service;

import com.ajit.alertops.model.Incident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentService {

    private final List<Incident> incidents = new ArrayList<>();

    public Incident addIncident(Incident incident) {
        incidents.add(incident);
        return incident;
    }

    public List<Incident> getAll() {
        return incidents;
    }

    public long highSeverityCount() {
        return incidents.stream()
                .filter(i -> "HIGH".equalsIgnoreCase(i.getSeverity()))
                .count();
    }
}
