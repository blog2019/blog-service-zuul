package com.blog.auth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@SpringCloudApplication
@RestController
public class BlogServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogServiceZuulApplication.class, args);
	}
	
	@GetMapping("/")
    public String welcome() {
        return "Welcome to blog2019 =) This is the Gateway.";
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @Component
    @EnableOAuth2Sso
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.
				antMatcher("/**")
				.authorizeRequests().anyRequest().authenticated()
				.and().authorizeRequests().antMatchers("/", "/health").permitAll()
				.and()
				.csrf().disable()
				.logout().logoutUrl("/logout").permitAll()
				.logoutSuccessUrl("/login");
        }
    }

}

