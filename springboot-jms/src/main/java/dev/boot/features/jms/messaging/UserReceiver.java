package dev.boot.features.jms.messaging;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class UserReceiver {

	private Logger log = LoggerFactory.getLogger(UserReceiver.class);
	private static AtomicInteger id = new AtomicInteger();

	@Autowired
	ConfirmationSender sender;

	@JmsListener(destination = "userQueue", containerFactory = "connectionFactory")
	public void receiveMessage(User receivedUser, Message msg) {
		log.info(">> received User " + receivedUser.toString());
		log.info(">> received OTP " + msg);

		sender.sendConfirmation(
				new Confirmation(id.incrementAndGet(), "User " + receivedUser.getEmailId() + "received."));
	}

}
