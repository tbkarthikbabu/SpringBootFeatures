package dev.boot.features.jms.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationReceiver {

	private Logger log = LoggerFactory.getLogger(ConfirmationReceiver.class);

	@JmsListener(destination = "confirmationQueue", containerFactory = "connectionFactory")
	public void receiveConfirmation(final Confirmation confirmation) {
		log.info(">> received confirmation " + confirmation);
	}

}
