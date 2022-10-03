package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * Classe de Configuração
 * Para usar restTemplate
 * Disponibilizar algumas instâncias de objetos
 */

@Configuration
public class AppConfig {
	
	//Método para registrar uma instância única
	//Padrão de Projeto Singleton de um objeto do tipo RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
