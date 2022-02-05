package com.bolsadeideas.springboot.backend.apirest;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootBackendApirestApplication implements CommandLineRunner{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestApplication.class, args);
	}
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOriginPatterns("http://localhost:4200").allowedMethods("*").allowedHeaders("*");
			}
		};
	}*/
	@Override
	public void run(String... args) throws Exception {
		String password ="12345";
		
		for (int i = 0; i < 4 ; i++) {
			String passwordEn = passwordEncoder.encode(password);
			System.out.println(passwordEn);
		}
		
	}

}
