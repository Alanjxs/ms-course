package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

//Registrar este service como componente do spring - @Component
//Mas usar o @Service fica mais específico como classe de serviço
@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
		
	}

}
