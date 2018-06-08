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
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableGlobalMethodSecurity(securedEnabled = true)
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
	        	/*.antMatcher("/test/*")
	        		.authorizeRequests()
	        		.anyRequest()
	        		.hasRole("ADMIN")
	        		.and()*/
	        	.authorizeRequests()
	        		.antMatchers("/outsideAccess/**").permitAll().and()
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
	}
}
