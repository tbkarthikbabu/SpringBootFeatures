package dev.boot.features.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * RestController = @Controller + @ResponseBody
 * 
 * makes that class as 'Request Handler'
 * 
 * simplify the creation of REST WebServices
 * 
 * @author karth
 *
 */
@RestController
@RequestMapping("/api")
public class WelcomeController {

	private static final String tempalte = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	/**
	 * RequestParam
	 * 
	 * Set: value to name and get it value as name in the method parameter
	 * 
	 * http://localhost:8080/hello/api/welcome?name=karthik
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/welcome")
	public Welcome getGreetingByRequest(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Welcome(counter.decrementAndGet(), String.format(tempalte, name));
	}

	/**
	 * 
	 * PathParam alias PathVariable
	 * 
	 * Set: send the value in request URL
	 * 
	 * http://localhost:8080/hello/api/welcome/vinod
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/welcome/{name}")
	public Welcome getGreetingByQuery(@PathVariable String name) {
		return new Welcome(counter.incrementAndGet(), String.format(tempalte, name));
	}

}
