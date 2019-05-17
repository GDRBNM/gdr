package com.gestion.recouvrement.bnm.securiter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorisationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	//authorisation de tous les domaine a envoyer une sql
		response.addHeader("Access-Control-Allow-Origin", "*");
		//liste des entete a autoriser
		response.addHeader("Access-Control-Allow-Headers","Origin, Accept,"
				+ " X-Requested-With,Content-Type,Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers,Authorization");
		//liste des entete que l'on peut exposerautrement dit authorisation du client a envoyer des entetes
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,"
				+ "Access-Control-Allow-Credentials,Authorization");
		response.addHeader("Access-Control-Allow-Methods","GET,PUT,POST,DELETE,PATCH,OPTIONS,HEAD");
		
		//
		
	//recuperation du jwt pour verifier que le jwt existe dans la requete envoyer
		String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);
	System.out.println("La valeur du token vaut :"+jwtToken);
	
	//les request sont envoyer aves options il faut les authoriser
	if (request.getMethod().equals("OPTIONS")) {
		response.setStatus(HttpServletResponse.SC_OK);
	}else {
		
		if (jwtToken==null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			//pour quitter la methode
			return ;
		}
		//sinon on sign le token
		//claims sont les revendication(le contenue du token)
		//on parse un token
		Claims claims=Jwts.parser()
		//on signe le token avec notre secret
		.setSigningKey(SecurityConstants.SECRET)
		//on supprime le prefix bearer
		.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX,""))
		//recupere le contenue du token
		.getBody();
		//si l'on veut recuperer l'utilisateur
		String username=claims.getSubject();






		//recuperation de la liste des Authoriter de cet utilisateur
		ArrayList<Map<String,String>> roles=(ArrayList<Map<String,String>>)claims.get("roles");
		//charger les roles
		Collection<GrantedAuthority>authorities=new ArrayList<>();
		//on parcour les roles et pour chaque role je fait un grant
		roles.forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		});
		//in formation passer a spring utilite pour lors d'utilisation d'annotation
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, null,authorities);
		//chargement des roles dans le context de spring
		//charge l'identiter de la personne qui a envoyer le role
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request, response);
	}
		
	}

}
