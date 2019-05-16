package com.gestion.recouvrement.bnm.securiter;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   // @Autowired
	//private DataSource dataSource;

	@Qualifier("userDetailsServiceImpl")
	@Autowired
	//il faut cree une classe qui va implementer cette interface
    private UserDetailsService userDetailsService;
//cree un bean au dans le main pour une instanciation au demarage
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

/*	//les utilisateurs qui ont le droit d'acceder a l'application
	auth.inMemoryAuthentication().withUser("samba").password("{noop}123").roles("ADMIN","USER");
	auth.inMemoryAuthentication().withUser("moussa").password("{noop}123").roles("USER");
*/
		//authwntification sera base par les service
		//la recuperation des roles et des user se fera dans le detail service
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}
@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub	
	http.csrf().disable(); 
	//utilisation du jwt au lieu de la session
	//desactivation de la session
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	//http.formLogin();
	http.headers().frameOptions().disable();
	 //toute les requetes necessite une authentification
	 http.authorizeRequests().antMatchers("/login/**","/register/**","/**","/v2/api-docs","/swagger-ui.html/**","/swagger-ui.html#/**","/application/**","/h2-console/**").permitAll();

	//http.authorizeRequests().antMatchers(HttpMethod.POST,"/listeMIEND/**").hasAuthority("ADMIN");
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/notificationDeMiseEnDemeures/search/listeMIEND/**").hasAuthority("RESPONSABLE_R");
	http.authorizeRequests().anyRequest().authenticated();
	//choix du filtre qui va gerer l'athentification
	http.addFilter(new JWTAuthentificationFilter(authenticationManager()));
	// ahthentification baser sur le username et le mot de passe
	http.addFilterBefore(new JWTAuthorisationFilter(), UsernamePasswordAuthenticationFilter.class);
}
}
