package in.book.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BookConfiguration {
    
	@Bean
	public SecurityFilterChain allowedUrls(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((request)->request.requestMatchers("/cancel" , "/book" , "/ticket" , "/view" , "/").permitAll().anyRequest().authenticated()).formLogin();
		return http.build();
	}
	
	
}
