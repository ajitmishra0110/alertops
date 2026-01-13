package com.ajit.alertops.controller;

import com.ajit.alertops.model.Incident;
import com.ajit.alertops.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IncidentController {

    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "AlertOps is running!";
    }

    @PostMapping("/incidents")
    public Incident report(@RequestBody Incident incident) {
        incident.setTimestamp(LocalDateTime.now());
        return service.addIncident(incident);
    }

    @GetMapping("/metrics")
    public Map<String, Object> metrics() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalIncidents", service.getAll().size());
        data.put("highSeverity", service.highSeverityCount());
        data.put("alert", service.highSeverityCount() > 3 ? "SYSTEM UNSTABLE" : "SYSTEM OK");
        return data;
    }

    @GetMapping("/incidents")
    public List<Incident> getAll() {
        return service.getAll();
    }

}
