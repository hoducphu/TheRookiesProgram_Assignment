package com.project.ecommercewebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.ecommercewebsite")
@EntityScan(basePackages = "com.project.ecommercewebsite")
@EnableJpaRepositories(basePackages = "com.project.ecommercewebsite.repository")
public class WatchShopEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchShopEcommerceApplication.class, args);
	}
}