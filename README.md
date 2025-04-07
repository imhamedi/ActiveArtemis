# ActiveMQ Artemis POC with Spring Boot

Ce projet est un Proof of Concept (POC) démontrant une manière simple, mais complète, d’envoyer et consommer des messages via ActiveMQ Artemis avec Spring Boot. Il fournit une base solide pour toute architecture orientée messages basée sur Artemis (JMS 2.0).

---

## 📌 Table of Contents

1. [📝 Overview](#-overview)
2. [⚙️ Features](#️-features)
3. [✅ Prerequisites](#-prerequisites)
4. [🚀 Setup](#-setup)
5. [▶️ Running the Project](#️-running-the-project)
6. [📡 Creating Queues and Topics](#-creating-queues-and-topics)
7. [🧪 Testing the Application](#-testing-the-application)
8. [📁 Project Structure](#-project-structure)

---

## 📝 Overview

Ce POC démontre :

- Un **producteur JMS** qui peut envoyer des messages vers une queue ou un topic Artemis.
- Un **consommateur de queue** (point-à-point, mode ANYCAST).==>avec teste de plusieurs consommateurs
- Un **consommateur de topic** (mode MULTICAST, style broadcast).==>avec teste de plusieurs topics
- Une **configuration JMS claire** pour Artemis avec Spring Boot.
- Une structure propre et modulaire pour un usage production-ready.

---

## ⚙️ Features

- **📤 Message Producer**  
  Envoi de messages vers `my-queue` ou `my-topic`.

- **📥 Queue Consumer**  
  Écoute les messages point-à-point dans la file `my-queue`.

- **📡 Topic Subscriber**  
  Reçoit chaque message publié sur le topic `my-topic` (multicast).

- **⚙️ Artemis Auto-Creation**  
  Les destinations (queues/topics) sont créées dynamiquement par Artemis si elles n'existent pas.

---

## ✅ Prerequisites

- Java 17+
- Maven
- ActiveMQ Artemis (≥ 2.30)
- Git
- (Facultatif) Visual Studio Code, IntelliJ ou Eclipse

---

## 🚀 Setup

1. **Cloner le projet**

```bash
git clone https://github.com/ton-utilisateur/activemq-artemis-springboot-template.git
cd activemq-artemis-springboot-template
```

2. **Configurer Artemis**

- Télécharger Artemis depuis : https://activemq.apache.org/components/artemis/download/
- Créer une instance via :

```bash
cd apache-artemis-x.y.z/bin
artemis.cmd create ../instance
```

- Lancer l'instance :

```bash
cd ../instance/bin
artemis.cmd run
```

3. **Configurer Spring Boot**

Dans `application.properties` :

```properties
spring.artemis.mode=native
spring.artemis.broker-url=tcp://localhost:61616
spring.artemis.user=admin
spring.artemis.password=admin
spring.artemis.embedded.enabled=false
```

---

## ▶️ Running the Project

Lancer l’application Spring Boot :

```bash
mvn spring-boot:run
```

Tu verras dans la console :

```
B Received from Queue: 1 Hello Queue!
Sent to Queue: 1 Hello Queue!
A Received from Queue: 2 Hello Queue!
Sent to Queue: 2 Hello Queue!
Default Received from Queue: 3 Hello Queue!
Sent to Queue: 3 Hello Queue!
B Received from Queue: 4 Hello Queue!
Sent to Queue: 4 Hello Queue!
A Received from Queue: 5 Hello Queue!
Sent to Queue: 5 Hello Queue!
Default Received from Queue: 6 Hello Queue!
Sent to Queue: 6 Hello Queue!
B Received from Queue: 7 Hello Queue!
Sent to Queue: 7 Hello Queue!
A Received from Queue: 8 Hello Queue!
Sent to Queue: 8 Hello Queue!
Default Received from Queue: 9 Hello Queue!
Sent to Queue: 9 Hello Queue!
B Received from Queue: 10 Hello Queue!
Sent to Queue: 10 Hello Queue!
Topic A Received from Topic: Topic 1!
Topic B Received from Topic: Topic 1!
Default Received from Topic: Topic 1!
Sent to Topic: Topic 1!
Default Received from Topic: Topic 2!
Topic B Received from Topic: Topic 2!
Topic A Received from Topic: Topic 2!
Sent to Topic: Topic 2!
Default Received from Topic: Topic 3!
Topic B Received from Topic: Topic 3!
Topic A Received from Topic: Topic 3!
Sent to Topic: Topic 3!
Default Received from Topic: Topic 4!
Topic B Received from Topic: Topic 4!
Topic A Received from Topic: Topic 4!
Sent to Topic: Topic 4!
Default Received from Topic: Topic 5!
Topic A Received from Topic: Topic 5!
Topic B Received from Topic: Topic 5!
Sent to Topic: Topic 5!
Topic B Received from Topic: Topic 6!
Topic A Received from Topic: Topic 6!
Default Received from Topic: Topic 6!
Sent to Topic: Topic 6!
```

Leproducteur envoie et les consommateurs affichent via leurs listeners respectifs.

---

## 📡 Creating Queues and Topics (optionnelle, le programme spring boot crée automatiquement les queues et topics)

> Artemis crée automatiquement les destinations si elles n’existent pas.  
Sinon, tu peux les créer via la console web : [http://localhost:8161/console](http://localhost:8161/console)

Ou via CLI :

```bash
artemis queue create --name my-queue --user admin --password admin
artemis address create --name my-topic --multicast --user admin --password admin
```

---

## 🧪 Testing the Application

- Lance l’application
- Regarde la console :
  - Producteur envoie des messages vers `IMHqueue` et `IMHtopic`
  - Listeners de queues répartissent les messages
  - Listeners des topics reçoivent tous les messages (broadcast)

---

## 📁 Project Structure

```
activemq/
├── src/main/java/com/template/activemq
│   ├── ActivemqApplication.java             # Classe principale Spring Boot
│
│   ├── config
│   │   └── ActiveMQConfig.java              # Configuration des listeners (topic support)
│
│   ├── producer
│   │   └── MessageProducerService.java      # Producteur de messages
│
│   ├── consumer
│       ├── QueueConsumer.java               # Listener pour queue
│       └── TopicSubscriber.java             # Listener pour topic
│       ├── QueueConsumerA.java               # Listener pour queue
│       └── TopicSubscriberA.java             # Listener pour topic
│       ├── QueueConsumerB.java               # Listener pour queue
│       └── TopicSubscriberB.java             # Listener pour topic
│
├── src/main/resources
│   └── application.properties               # Configuration Artemis / Spring Boot
└── README.md
```

---

> ✨ Ce POC peut servir de **starter Artemis/Spring Boot** pour des architectures orientées événements.
