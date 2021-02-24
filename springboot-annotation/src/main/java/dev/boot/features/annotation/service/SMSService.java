package dev.boot.features.annotation.service;

import org.springframework.stereotype.Service;

@Service("SMSService")
public class SMSService implements MessageService {

	@Override
	public void sendMsg(String msg) {
		System.out.println("SMS Notication-->" + msg);
	}

}
