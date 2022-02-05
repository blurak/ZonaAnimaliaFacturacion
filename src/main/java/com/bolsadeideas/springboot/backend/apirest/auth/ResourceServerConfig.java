package com.bolsadeideas.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer 
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/clientes/consultarTodas", "/clientes/consultar/page/**","/clientes/uploads/img/**","/imges/**").permitAll()
		.antMatchers("/clientes/cliente/{id}").permitAll()
		.antMatchers("/facturas/**").permitAll()
		/*.antMatchers(HttpMethod.GET,"/clientes/cliente/{id}").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/clientes/upload").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST,"/clientes/crear").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/clientes/eliminar/{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/clientes/editar").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/clientes/regiones").hasRole("ADMIN")*/		
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource(){
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200/"));
		config.setAllowedOriginPatterns(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new  UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	@Bean
	public CorsFilter corsFilter(){
		CorsFilter bean = new CorsFilter(corsConfigurationSource());
		
		return bean;
	}

	
	
	
}
