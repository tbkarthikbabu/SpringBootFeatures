package dev.boot.features.jms.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationSender {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendConfirmation(final Confirmation confirmation) {
		jmsTemplate.convertAndSend("confirmationQueue", confirmation);
	}

}
