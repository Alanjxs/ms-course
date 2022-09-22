package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
	
	/*
	 * Criação de Beans Jwt que é um padrão para autenticação e troca de informações.
	 */
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("MY-SECRET-KEY");//chave secreta para assinar os tokens
		return tokenConverter;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter()); //Responsável por ler as informações do token
	}

}
