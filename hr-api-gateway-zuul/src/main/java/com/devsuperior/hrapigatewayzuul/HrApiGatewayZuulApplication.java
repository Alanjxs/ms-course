package com.devsuperior.hrapigatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
 * Zuul: é uma solução de roteamento dinâmico que possibilita monitoramento, resiliência e segurança para aplicações, 
 * também pode ser encontrada no sub-projeto spring-cloud-netflix.
 * Porta padrão de um gateway-zuul é 8765
 */
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class HrApiGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayZuulApplication.class, args);
	}

}
