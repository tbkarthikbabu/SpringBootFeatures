package dev.boot.features.annotation.service;

import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailService implements MessageService {

	@Override
	public void sendMsg(String msg) {
		System.out.println("Email Notication" + msg);
	}

}
