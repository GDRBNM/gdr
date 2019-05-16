package com.gestion.recouvrement.bnm.service;

import java.util.ArrayList;
import java.util.Collection;

import com.gestion.recouvrement.bnm.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	// interface qui gere les utilisateurs
	private AccountService accountService; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur user=accountService.findUserByUsername(username);
		if(user==null)throw new UsernameNotFoundException(username); 
		//collection de role
		Collection<GrantedAuthority> authtorities=new ArrayList<>();
		//recuperation de chaque role en lui donnant un grant la dessus
		//pour chaque role r on ajoute une authoroties(on donne le nom du role)
		//on dit a spring que l'on lui renvoie le user avec les roles adequat
		user.getRoles().forEach(r->{
			authtorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		
		return new User(user.getUsername(),user.getPassword(),authtorities);
	}

}
