package com.exo.WebAPI.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exo.WebAPI.Model.User;
import com.exo.WebAPI.Repository.UserRepositories;

public class UserController {

	@Autowired // This means to get the bean called userRepository
	private UserRepositories userRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name,@RequestParam String email, @RequestParam String password) {
			// @ResponseBody means the returned String is the response, not a view name
			// @RequestParam means it is a parameter from the GET or POST request

			User u = new User();
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			userRepository.save(u);
			return "Saved";
			}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
	// This returns a JSON or XML with the users
	return userRepository.findAll();
	}
}
