package com.emersondantas.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.emersondantas.cursomc.domain.Cliente;
import com.emersondantas.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
