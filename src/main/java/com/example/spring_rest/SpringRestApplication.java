package com.example.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Mark Heckler. Spring Boot: Up and Running
 * Главный класс приложения Spring Boot.
 * 
 * Аннотация @SpringBootApplication включает автоматическую настройку Spring,
 * сканирование компонентов и конфигурацию приложения.
 * 
 * Запуск метода main() запускает встроенный сервер и всё приложение.
 */

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}
}

