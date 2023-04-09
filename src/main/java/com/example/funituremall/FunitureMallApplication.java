package com.example.funituremall;

import com.example.funituremall.model.Furniture;
import com.example.funituremall.repository.FurnitureRepository;
import com.example.funituremall.repository.UserRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories
public class FunitureMallApplication implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FurnitureRepository furnitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(FunitureMallApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins("*")
					.allowedHeaders("*")
					.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
					.maxAge(-1)   // add maxAge
					.allowCredentials(false);
			}
		};
	}

	public void run(String... args) {
		System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");

		//File file = new File("/Users/shenandi/Downloads/阿拉伯柱-min-min.jpg");
		//try {
		//	byte[] bytes = Files.readAllBytes(file.toPath());
		//	furnitureRepository.update("阿拉伯柱", bytes);
		//} catch (IOException e) {
		//	throw new RuntimeException(e);
		//}
		//
		//List<Furniture> furnitures = furnitureRepository.queryAll();
		//
		//for (Furniture furniture: furnitures) {
		//	System.out.println(furniture.getPictureBytes());
		//}


	}
}
