package com.template.activemq;

import com.template.activemq.producer.MessageProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqApplication.class, args);
	}

	// Cette méthode s'exécutera après le démarrage de l'application
	@Bean
	CommandLineRunner demo(MessageProducerService producer) {
		return args -> {
			producer.sendToQueue("IMHqueue", "1 Hello Queue!");
			producer.sendToQueue("IMHqueue", "2 Hello Queue!");
			producer.sendToQueue("IMHqueue", "3 Hello Queue!");
			producer.sendToQueue("IMHqueue", "4 Hello Queue!");
			producer.sendToQueue("IMHqueue", "5 Hello Queue!");
			producer.sendToQueue("IMHqueue", "6 Hello Queue!");
			producer.sendToQueue("IMHqueue", "7 Hello Queue!");
			producer.sendToQueue("IMHqueue", "8 Hello Queue!");
			producer.sendToQueue("IMHqueue", "9 Hello Queue!");
			producer.sendToQueue("IMHqueue", "10 Hello Queue!");

			producer.sendToTopic("IMHtopic", "Topic 1!");
			producer.sendToTopic("IMHtopic", "Topic 2!");
			producer.sendToTopic("IMHtopic", "Topic 3!");
			producer.sendToTopic("IMHtopic", "Topic 4!");
			producer.sendToTopic("IMHtopic", "Topic 5!");
			producer.sendToTopic("IMHtopic", "Topic 6!");
		};
	}
}
