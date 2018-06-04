package noteBook.Baptiste.Chartier.noteBook.Baptiste.Chartier;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		
		@Autowired
		DataSource dataSource;
		
		//on configure l'authentification
		@Autowired
		 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		   auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery(
		   "select email, password, enable from customer where email=?")
		  .authoritiesByUsernameQuery(
		   "select email, role from role where email=?");
		 } 
		
		//on configure les accès au niveau des routes
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
	    public PasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder newPasswordEncoder = new BCryptPasswordEncoder();
	        return newPasswordEncoder;
	    }
/*
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
	    }*/
		
		@Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	        UserDetails user =
	             User.withUserDetails(userDetails)
	                .username("user")
	                .password("password")
	                .roles("USER")
	                .build();

	        return new InMemoryUserDetailsManager(user);
	    }
	    
	}
}
