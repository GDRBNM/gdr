package com.gestion.recouvrement.bnm.securiter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestion.recouvrement.bnm.entities.Utilisateur;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter{

	//de spring securiter
	private AuthenticationManager authenticationManager; 
	
	//constructeur
	public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}
	//authentification en utilisant un format json
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		//recuperation des donner envoyer
		// recuperation des donner au format json pour les deserialiser 
		Utilisateur appUser=null;
		//prendre le json et le stocker dans un objet java
		try {
			//a chaque tentative d'authentification on cree un objet
			appUser=new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
		} catch (Exception e) {

			throw new RuntimeException("erreur dans la saisie du username ou passord");
		}
		System.out.println("*****************************");
		System.out.println("username "+appUser.getUsername());
		System.out.println("password "+appUser.getPassword());
		//retour a spring securiter un objet de type authetification manager avec les username et password 
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
	}
	
	//appler apres avoir ete authentifier
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		//infomation sur le user
		User springUser= (User) authResult.getPrincipal();
		//generation du token a partir de ses information
		// definition du header payload et siganture
		String jwt=Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles",springUser.getAuthorities())
				.compact();
		//envoie du token dans le response au niveau du header
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
		
	}
}
