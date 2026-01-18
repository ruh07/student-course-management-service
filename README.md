🎓 Student Course Management Service

A Spring Boot microservice for managing students, courses, and assignments, built using RESTful APIs, PostgreSQL, and Spring Boot Actuator with a focus on clean architecture and real-world backend practices.

🚀 Features
👩‍🎓 Student Management

Register new students with validation
Fetch all students or find by ID
Update or delete student records
Search students by ID or Name
Filter students by enrollment date & active status

📚 Course Management

Create and retrieve courses
Register students for courses (Many-to-Many relationship)
Fetch course details by ID

📝 Assignment Management

Assign tasks to students
Save students along with assignments

Fetch:
All students with their assignments
All assignments with corresponding student details

Uses DTOs to control API responses

⚙️ Operational & Technical

PostgreSQL integration using Spring Data JPA
Actuator endpoints for application monitoring
REST-compliant HTTP status codes
Cross-Origin support for frontend integration

🏗️ Architecture Overview

Microservice-based backend
Layered architecture:
Controller Layer (REST APIs)
Service Layer (Business Logic)
Repository Layer (Persistence)
DTO pattern to avoid exposing entities directly
Clean separation of concerns
Controller → Service → Repository → PostgreSQL

🛠️ Tech Stack

Java 21
Spring Boot
Spring Web (REST APIs)
Spring Data JPA
Spring Validation
Spring Boot Actuator
PostgreSQL
Lombok
Maven

📌 API Endpoints (Sample)
Student APIs
GET    /allstudents
POST   /registerStudent
GET    /findStudent/{id}
PUT    /upsertStrudent/{id}
DELETE /deleteStudent/{id}
GET /StudentSearchByIdOrName?id={id}&studentName={name}
GET /StudentsByDate?enrollDate={date}&activeEnrollment={true|false}

Course APIs
GET  /Courses/AllCourses
GET  /Courses/{id}
POST /Courses/SaveCourse
POST /Courses/RegisterForCourse/Student/{studentId}/Course/{courseId}

Assignment APIs
POST /Assignment/SaveStudentAndAssignment
POST /Assignment/SetAssignmentForStudent?id={id}&task={task}

GET /Assignment/AllStudentsWithAssignments
GET /Assignment/AllAssignmentsWithStudents

📊 Actuator Endpoints
/actuator/health
/actuator/info
/actuator/metrics


Used to monitor application health and runtime metrics.

🧪 Validation & Error Handling

Bean validation using @Valid
Clean request handling with meaningful HTTP responses
Defensive checks for invalid student/course references

🗄️ Database Design

Student
One-to-Many → Assignments
Many-to-Many → Courses

Course
Many-to-Many → Students

Assignment
Many-to-One → Student

▶️ How to Run Locally

Clone the repository

git clone https://github.com/your-username/student-course-management-service.git

Configure PostgreSQL in application.yml / application.properties

Run the application

mvn spring-boot:run


Access APIs at

http://localhost:8080

🎯 Learning Outcomes

Designed REST APIs following industry standards
Implemented entity relationships using JPA
Applied DTO pattern for response modeling
Used Actuator for production-readiness
Hands-on experience with PostgreSQL-backed microservices

🔮 Future Enhancements

Spring Security with JWT authentication
Pagination & sorting
Swagger / OpenAPI documentation
Dockerization
Separate microservices for Course & Assignment domains

👤 Author

Ruchi Agarwal
Backend Engineer | Java | Spring Boot | Microservices
