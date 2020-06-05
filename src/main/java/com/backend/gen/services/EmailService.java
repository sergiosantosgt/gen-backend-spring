package com.backend.gen.services;

import com.backend.gen.domain.Cliente;
import com.backend.gen.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
