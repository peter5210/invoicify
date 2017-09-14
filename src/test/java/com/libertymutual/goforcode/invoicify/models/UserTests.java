package com.libertymutual.goforcode.invoicify.models;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class UserTests {

	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .build();
        tester.testBean(User.class, configuration);
  
	}

	
	@Test
	public void is_the_account_non_expired_meaning_still_active() {
		//Arrange
		User user = new User();
		
		//Act
		user.isAccountNonExpired();
		
		//Assert
		assertThat(user.isAccountNonExpired()).isEqualTo(true);
	}
	
	@Test
	public void is_the_account_non_locked_meaning_unlocked() {
		//Arrange
		User user = new User();
		
		//Act
		user.isAccountNonLocked();
		
		//Assert
		assertThat(user.isAccountNonLocked()).isEqualTo(true);
	}
	
	@Test
	public void are_the_creditials_not_exipred() {
		//Arrange
		User user = new User();
		
		//Act
		user.isCredentialsNonExpired();
		
		//Assert
		assertThat(user.isCredentialsNonExpired()).isEqualTo(true);
	}
	
	@Test
	public void is_the_user_enabled() {
		//Arrange
		User user = new User();
		
		//Act
		user.isEnabled();
		
		//Assert
		assertThat(user.isEnabled()).isEqualTo(true);
	}	
	
	@Test
	public void testing_the_constructor() {
		//arrange
		String username = "Peter";
		String password = "abcdef";
		String roleName = "ADMIN";
		
		//act
		User user = new User(username, password, roleName);
		
		//assert
		assertThat(user.getPassword()).isEqualTo("abcdef");
		assertThat(user.getUsername()).isEqualTo("Peter");
		assertThat(user.getRoles()).isEqualTo("ADMIN");
		
	}
	
}
