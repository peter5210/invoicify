package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepo;

@Configuration
@Profile("development")
public class SeedData {
	
	public SeedData(UserRepo userRepo) {
		userRepo.save(new User("peter", "password"));
		userRepo.save(new User("admin", "admin"));
		userRepo.save(new User("clerk", "clerk"));
		userRepo.save(new User("accountant", "accountant"));
	}
	
	
	

}
