ActiveMQ Artemis POC with Spring Boot
Ce projet est un Proof of Concept (POC) démontrant une manière simple, mais complète, d’envoyer et consommer des messages via ActiveMQ Artemis avec Spring Boot. Il fournit une base solide pour toute architecture orientée messages basée sur Artemis (JMS 2.0).

📌 Table of Contents
📝 Overview

⚙️ Features

✅ Prerequisites

🚀 Setup

▶️ Running the Project

📡 Creating Queues and Topics

🧪 Testing the Application

📁 Project Structure

🚧 Potential Improvements

📝 Overview
Ce POC démontre :

Un producteur JMS qui peut envoyer des messages vers une queue ou un topic Artemis.

Un consommateur de queue (point-à-point, mode ANYCAST).

Un consommateur de topic (mode MULTICAST, style broadcast).

Une configuration JMS claire pour Artemis avec Spring Boot.

Une structure propre et modulaire pour un usage production-ready.

⚙️ Features
📤 Message Producer
Envoi de messages vers my-queue ou my-topic.

📥 Queue Consumer
Écoute les messages point-à-point dans la file my-queue.

📡 Topic Subscriber
Reçoit chaque message publié sur le topic my-topic (multicast).

⚙️ Artemis Auto-Creation
Les destinations (queues/topics) sont créées dynamiquement par Artemis si elles n'existent pas.

✅ Prerequisites
Java 17+

Maven

ActiveMQ Artemis (≥ 2.30)

Git

(Facultatif) Visual Studio Code, IntelliJ ou Eclipse

🚀 Setup
Cloner le projet

bash
Copy
Edit
git clone https://github.com/ton-utilisateur/activemq-artemis-springboot-template.git
cd activemq-artemis-springboot-template
Configurer Artemis

Télécharger Artemis depuis : https://activemq.apache.org/components/artemis/download/

Créer une instance via :

bash
Copy
Edit
cd apache-artemis-x.y.z/bin
artemis.cmd create ../instance
Lancer l'instance :

bash
Copy
Edit
cd ../instance/bin
artemis.cmd run
Configurer Spring Boot

Dans application.properties :

properties
Copy
Edit
spring.artemis.mode=native
spring.artemis.broker-url=tcp://localhost:61616
spring.artemis.user=admin
spring.artemis.password=admin
spring.artemis.embedded.enabled=false
▶️ Running the Project
Lancer l’application Spring Boot :

bash
Copy
Edit
mvn spring-boot:run
Tu verras dans la console :

vbnet
Copy
Edit
Sent to Queue: Hello Queue!
Sent to Topic: Hello Topic!
Et ensuite les consommateurs les afficheront via leurs listeners respectifs.

📡 Creating Queues and Topics
Artemis crée automatiquement les destinations si elles n’existent pas.
Sinon, tu peux les créer via la console web : http://localhost:8161/console

Ou via CLI :

bash
Copy
Edit
artemis queue create --name my-queue --user admin --password admin
artemis address create --name my-topic --multicast --user admin --password admin
🧪 Testing the Application
Lance l’application

Regarde la console :

Producteur envoie 1 message vers my-queue et my-topic

Listener de queue reçoit le message (1 seul listener)

Listener de topic reçoit tous les messages (broadcast)

📁 Project Structure
bash
Copy
Edit
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
│
├── src/main/resources
│   └── application.properties               # Configuration Artemis / Spring Boot
└── README.md
