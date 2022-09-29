package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
/*
 * Resource será criado para poder usar o projeto(API) como webservice
 * Para funcionar como webservice precisa ter as anotações
 * @RestController
 * @RequestMapping(value = "/workers") - caminho padrão deste recurso
 */

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	/* Receber informações do Github
	@Value("${test.config}")
	private String testConfig;
	*/
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;//Injetar uma dependência usando o framework através do @Autowired
	
	@GetMapping(value = "/configs") //Criação de um subcaminho para chamar no postman
	public ResponseEntity<Void> getConfigs() {
		//logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}		
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll(); //Busca todos os registros no BD e instancia a lista
		return ResponseEntity.ok(list);
	}	
	
	//Passando argumento pela requisição digitada na url
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		/*
		 * Sleep para aguardar 3 segundos
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
}