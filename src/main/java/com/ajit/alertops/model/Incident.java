package com.ajit.alertops.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "incidents")
public class Incident {

    @Id
    private Long id;

    private String service;
    private String severity;
    private String message;
    private LocalDateTime timestamp;

    public Incident() {
    }

    public Incident(String service, String severity, String message, LocalDateTime timestamp) {
        this.service = service;
        this.severity = severity;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
