# AWS Fundamentals – ChatBot Project

## AWS Services Learned

### 1. EC2
EC2 (Elastic Compute Cloud) provides virtual servers in AWS.

**Use:** Run applications on a virtual server.

---

### 2. RDS
RDS (Relational Database Service) provides managed relational databases.

**Our project:**
- Database: PostgreSQL
- AWS service: Amazon RDS

---

### 3. ECR
ECR (Elastic Container Registry) stores Docker images.

Our flow:

Dockerfile
↓
Docker Image
↓
Amazon ECR

---

### 4. ECS
ECS (Elastic Container Service) manages and runs containers.

Our application will use ECS to manage the Spring Boot container.

---

### 5. Fargate
Fargate provides compute for running containers without managing the underlying servers.

Our planned architecture:

ECS + Fargate
↓
Spring Boot Docker Container

---

### 6. IAM
IAM (Identity and Access Management) controls access and permissions for AWS resources.

**Use:**
- Users
- Roles
- Permissions
- Policies

---

### 7. CloudWatch
CloudWatch is used for monitoring and collecting logs.

Our Spring Boot application can eventually send application logs to CloudWatch.

---

### 8. Secrets Manager
AWS Secrets Manager securely stores sensitive information.

Examples:
- Database passwords
- API keys
- Other credentials

We should not hard-code sensitive credentials in our application.

---

### 9. VPC
VPC (Virtual Private Cloud) provides an isolated network environment in AWS.

Our AWS resources will eventually be placed within a VPC.

---

### 10. ALB
ALB (Application Load Balancer) receives HTTP/HTTPS requests and forwards them to our application.

Request flow:

User
↓
ALB
↓
ECS + Fargate
↓
Spring Boot
↓
RDS PostgreSQL

---

## Planned ChatBot AWS Architecture

Internet
↓
Application Load Balancer
↓
ECS + Fargate
↓
Spring Boot
↓
Amazon RDS PostgreSQL

Supporting services:

- ECR → Docker images
- IAM → Permissions
- Secrets Manager → Secrets
- CloudWatch → Logs and monitoring
- VPC → Network

## Current Status

- [x] Spring Boot fundamentals
- [x] REST APIs
- [x] CRUD
- [x] JPA / Hibernate
- [x] PostgreSQL
- [x] Validation
- [x] Global exception handling
- [x] Logging
- [x] Docker
- [x] Docker Compose
- [x] Testing
- [x] AWS fundamentals
- [ ] AWS deployment
- [ ] RDS setup
- [ ] ECR setup
- [ ] ECS + Fargate
- [ ] Secrets Manager
- [ ] CloudWatch
- [ ] AI integration
- [ ] React frontend
- [ ] GitHub Actions CI/CD