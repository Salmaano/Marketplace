package com.example.Marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/listings").allowedOrigins("http://0.0.0.0:8000");
				registry.addMapping("/buyer/create").allowedOrigins("http://0.0.0.0:8000");
			}

			@Override
			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
				configurer.favorPathExtension(false).
						favorParameter(true).
						defaultContentType(MediaType.APPLICATION_JSON);
			}
		};
	}

}
