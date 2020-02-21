package kr.team1.app.config.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;

@Configuration @EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/res/**");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
		    
		    .authorizeRequests()
				.antMatchers("/**").permitAll()
//				.antMatchers("/userUpdate", "/board/up", "/joinSuccess").authenticated()
//		    	.antMatchers("/signup").anonymous()
//		    	.antMatchers("/signup").access("hasAuthority(9)").access("isAnonymous()").access("isAuthenticated()")
		    	.anyRequest().permitAll() 
				.and()
			.formLogin()
				.loginPage("/logindiv")
				.usernameParameter("id")
				.passwordParameter("pwd")
				.loginProcessingUrl("/login")
				.successForwardUrl("/security/success")
				.failureForwardUrl("/security/error")
				.permitAll()
				.and()
			.exceptionHandling()
		    	.accessDeniedPage("/security/denied")
		    	.and()
			.logout()
//				.logoutUrl("/")
				.logoutSuccessUrl("/security/logout")
				.invalidateHttpSession(true)
				.deleteCookies(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY)
				.and()
			.httpBasic();
	}

	@Autowired private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("root").password("1234").roles("ADMIN")
//			.and()
//			.withUser("user").password("1234").roles("USER");
		
//		auth.jdbcAuthentication()
//          .dataSource(dataSource);
		
		auth.jdbcAuthentication()
	        .dataSource(dataSource)
	        .usersByUsernameQuery("select id, pwd, enabled from USERS where id = ?")
	        .authoritiesByUsernameQuery("select id, role from USERS where id = ?");
	}
	
}
