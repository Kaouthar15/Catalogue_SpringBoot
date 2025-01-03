package com.ntt.Catalogue.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntt.Catalogue.models.User;
import com.ntt.Catalogue.models.UserDto;
import com.ntt.Catalogue.services.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {
	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto,
	                            BindingResult result, Model model) {
	    User existingUser = userService.findUserByEmail(userDto.getEmail());
	    
	    if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
	        result.rejectValue("email", null, "There is already an account registered with the same email");
	    }
	    if (result.hasErrors()) {
	        model.addAttribute("user", userDto);
	        return "/register";
	    }
	    
	    // Determine the role based on the checkbox
	    String role = userDto.isRoleCheckbox() ? "ROLE_USER" : "ROLE_ADMIN";
	    userService.saveUser(userDto, role);
	    
	    return "redirect:/register?success";
	}

	@GetMapping("/users")
	public String users(Model model) {
		List<UserDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
}