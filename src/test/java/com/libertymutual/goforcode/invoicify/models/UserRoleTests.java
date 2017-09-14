package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class UserRoleTests {

	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .build();
        tester.testBean(UserRole.class, configuration);
  
	}

	@Test
	public void checking_the_constructor_works( ) {
		//arrange
		String name = "ADMIN";
		User user = new User();
		
		//act
		UserRole userRole = new UserRole(name, user);
			
		//assert
		assertThat(userRole.getName()).isEqualTo("ADMIN");
		assertThat(userRole.getUser()).isSameAs(user);
	
	}
	
}
