package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;

@Controller
public class Login {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		return "Login";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		System.out.println("User Page Requested");
		String uname = user.getUserName();
		String pass = user.getPassword();
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("password", user.getPassword());
		if (uname.equals("Streak") && pass.equals("imran")) {

			return "CRUD";
		}
		return "sorry";
	}
}
