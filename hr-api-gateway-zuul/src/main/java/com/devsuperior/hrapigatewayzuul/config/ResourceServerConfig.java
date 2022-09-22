package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private JwtTokenStore tokenStore;
	
	//Colocar os caminhos que serão públicos
	private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
	
	//Rotas que precisrão de autorização de pelo menos operador
	private static final String[] OPERATOR = {"/hr-worker/**"};
	
	//Rotas que precisrão de autorização de pelo menos operador
	private static final String[] ADMIN = {"/hr-payroll/**", "/hr-user/**"};
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);//Agora nosso projeto consegue ler o token
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Definir as autorizações
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	

}
