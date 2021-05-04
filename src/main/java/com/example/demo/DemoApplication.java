package com.example.demo;

import com.example.demo.Constants.TempMapsEnum;
import com.wrapper.spotify.SpotifyApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
/**
 * @author: Sharvari Nagesh
 * Main Function 
 */
@SpringBootApplication
public class DemoApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
