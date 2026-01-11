# 🚨 AlertOps – Smart Incident Monitoring System

AlertOps is a Spring Boot–based incident monitoring system that simulates how modern DevOps teams track system issues, analyze severity, and trigger alerts.  
The application is containerized with Docker and deployed on Kubernetes using Minikube.

This project demonstrates real-world backend + DevOps skills including REST APIs, Docker, Kubernetes, and GitHub workflows.

---

## 🔹 Features

- Health monitoring endpoint
- Incident reporting API
- Severity-based alert logic
- Real-time metrics summary
- Dockerized application
- Kubernetes deployment with scaling support

---

## 🛠️ Tech Stack

Backend: Spring Boot (Java 21+)  
Build Tool: Maven  
Containerization: Docker  
Orchestration: Kubernetes (Minikube)  
Version Control: Git & GitHub  
OS: Windows 11

---

## 📂 Project Structure

alertops/  
├── src/                  # Spring Boot source code  
├── k8s/                  # Kubernetes YAML files  
├── Dockerfile            # Docker image configuration  
├── pom.xml               # Maven configuration  
└── README.md

---

## 🚀 API Endpoints

### 1) Health Check
GET /api/health

Response:  
AlertOps is running!

---

### 2) Report an Incident
POST /api/incidents

Example request body:  
{
"service": "payment-service",
"severity": "HIGH",
"message": "Timeout error"
}

---

### 3) View Metrics
GET /api/metrics

Example response:  
{
"totalIncidents": 5,
"highSeverity": 4,
"alert": "SYSTEM UNSTABLE"
}

---

## 🐳 Run with Docker

Build the JAR  
mvn clean package

Build Docker Image  
docker build -t alertops .

Run Container  
docker run -p 8080:8080 alertops

Open in browser:  
http://localhost:8080/api/health

---

## ☸️ Run on Kubernetes (Minikube)

Start Minikube  
minikube start

Load Docker Image  
minikube image load alertops

Deploy App  
kubectl apply -f k8s/deployment.yaml  
kubectl apply -f k8s/service.yaml

Access Service  
minikube service alertops-service

Then open:  
/api/health

---

## 📈 Scaling the Application

kubectl scale deployment alertops-deployment --replicas=4

---

## 🎯 What This Project Demonstrates

- Real-world REST API design
- Docker image creation
- Kubernetes deployment & services
- DevOps workflow with GitHub
- Monitoring & alerting logic
- Production-style backend architecture

---

## 👨‍💻 Author

Ajit Mishra  
Backend & DevOps Enthusiast

GitHub: https://github.com/YOUR-USERNAME

---

## ⭐ If you like this project, give it a star!
