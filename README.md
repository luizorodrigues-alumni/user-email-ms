# 🧩 Microservices: User Registration + Email Sender

This project demonstrates a simple microservice architecture using Spring Boot and RabbitMQ. It consists of two services: `user` (handles user registration) and `email` (sends a welcome email). When a new user is registered, the `user` service sends a message to a RabbitMQ queue. The `email` service listens to this queue and sends an email using SMTP.

---

## 📌 Technologies Used

- Java
- Spring Boot
- RabbitMQ
- Spring AMQP
- Spring Mail (JavaMailSender)

---

## 🔄 Communication Flow

1. The client sends a `POST /users` request to the `user` service.
   
Example:
- Request Body (JSON):
    ```json
   {
  	 "name": "YOUR NAME",
  	 "email": "YOUR_EMAIL@EMAIL.com"
    }
    ```
- Response: `201 Created`
3. The `user` service stores the new user in the database and publishes a message to RabbitMQ.
4. The `email` service listens to the queue, receives the message, and sends a welcome email to the registered user.

---

## ⚙️ Getting Started
### 1. Clone the Repository

```bash
git clone https://github.com/luizorodrigues-alumni/user-email-ms.git
cd user-email-ms
```
### 2. Set up Environment Variables
Each microservice has its own .env file to store sensitive credentials and configuration.

Example:

```bash
  #DB
  DB_URL=YOUR_DATABASE_URL
  DB_USER=YOUR_DATABASE_USER
  DB_PASS=YOUR_DATABASE_PASS
  
  #RabbitMQ
  RMQ_ADDRESS=YOUR_RABBITMQ_ADDRESS
  RMQ_QUEUE=YOUR_RABBITMQ_QUEUE
  
  #SMTP
  MAIL_USERNAME=YOUR_EMAIL
  MAIL_PASS=YOUR_APP_PASSWORD
```

### 3. Run the Services
In two separate terminals, navigate to each microservice directory and run:
```bash
./mvnw spring-boot:run
```


