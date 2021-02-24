package dev.boot.features.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 
 * provides the business functionalities
 * 
 * @Component is generic sterrotype for spring managed component
 * 
 *            @Respositry, @Controller, @Service are specific usecase for
 *            component in spring
 * 
 * @author karth
 *
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * @Qualifier is used to specific bean name to be wired
	 * 
	 *            Ex: MessageService have the two different serviec with the same
	 *            type so that using Qualifier to exact bean wired
	 * 
	 */
	@Autowired
	@Qualifier("SMSService")
	private MessageService service;

	@Override
	public void processMsg(String msg) {

		service.sendMsg(msg);
	}

}
