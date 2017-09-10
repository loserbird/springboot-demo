package com.loserbird;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                .antMatchers("/","/login").permitAll()//根路径和/login路径不拦截
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .loginPage("/login") //登陆页面
	                .defaultSuccessUrl("/chat") //登陆成功转向该页面
	                .permitAll()
	                .and()
	                .logout()
	                .permitAll();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    		auth
	                .inMemoryAuthentication()
	                .withUser("loserbird").password("123456").roles("USER")
	                .and()
	                .withUser("xiaoer").password("123456").roles("USER");
	    }
	    //5忽略静态资源的拦截
	    @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/static/**");
	    }
}
