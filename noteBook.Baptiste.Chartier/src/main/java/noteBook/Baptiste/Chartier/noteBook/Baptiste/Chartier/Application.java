package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	
	
	
	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                //.antMatchers("/", "/home").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }

	    @Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	        UserDetails user =
	             User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("password")
	                .roles("USER")
	                .build();
	        
	        UserDetails user2 =
	        	User.withDefaultPasswordEncoder()
	        		.username("toto")
	        		.password("tutu")
	        		.roles("TOTO")
	        		.build();
	        
	        List<UserDetails> listUsers = new ArrayList<>();
	        listUsers.add(user);
	        listUsers.add(user2);

	        return new InMemoryUserDetailsManager(listUsers);
	    }
	    
	}
}
