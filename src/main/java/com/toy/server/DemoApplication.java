package com.toy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Profile({"usage_message"})
//	@Bean
//	public CommandLineRunner usage() {
//		return new CommandLineRunner() {
//
//			@Override
//			public void run(String... strings) throws Exception {
//				System.out.println("This app");
//			}
//		};
//	}
//
//	@Profile("!usage_message")
//	@Bean
//	public CommandLineRunner tutorial() {
//		return new RabbitAmqpTutorialRunner();
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
