package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

//Registrar este service como componente do spring - @Component
//Mas usar o @Service fica mais específico como classe de serviço
@Service
public class PaymentService {
	
	//@value permiti definir uma expression que recebe os dados do arquivo de propriedades
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		//Mapa de parâmetros para receber a informação via GET na URL 
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		//Fazer a leitura dos dados via GET na URL
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
