package com.libertymutual.goforcode.invoicify.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepo;

@Controller
@RequestMapping("/")
public class HomeController {

	private UserRepo userRepo;
	private PasswordEncoder encoder;

	public HomeController(UserRepo userRepo, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.encoder = encoder;
	}

	@GetMapping("")
	public String defaultPage() {
		return "home/default";
	}

	@GetMapping("signup")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView("home/signup");
		return mv;
	}

	@PostMapping("signup")
	public ModelAndView handleSignup(User user) {
		// TODO this is a bad idea! Needs refactoring
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);

		ModelAndView mv = new ModelAndView();
		try {
			userRepo.save(user);
			mv.setViewName("redirect:/login");
		} catch (DataIntegrityViolationException dive) {
			mv.setViewName("home/signup");
			mv.addObject("errorMessage", "Pick a unique user name");
		}
		return mv;
	}

}
