package dev.boot.features.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.boot.features.data.services.UserAndOrderService;

@Controller
public class KartController {

	@Autowired
	private UserAndOrderService userOrderService;

	@RequestMapping(value = { "/", "/app/users" }, method = RequestMethod.GET)
	public String getUsers(Model mode) {
		mode.addAttribute("users", userOrderService.getUsers());
		return "users";

	}

}
