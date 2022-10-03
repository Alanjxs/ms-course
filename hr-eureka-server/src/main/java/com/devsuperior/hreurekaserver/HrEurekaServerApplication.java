package com.devsuperior.hreurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*
 * Classe para implementação/configuração do Servidor Eureka 
 * Precisa de uma dependêcia jaxb-runtime no arquivo pom.xml, além da prória eureka
 * @EnableEurekaServer - para configurar como servidor eureka
 * as configurações ficam no arquivo application.properties, porta padrão 8761 
 */
@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServerApplication.class, args);
	}

}
