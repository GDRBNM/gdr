package com.gestion.recouvrement.bnm.service;



import com.gestion.recouvrement.bnm.entities.Role;
import com.gestion.recouvrement.bnm.entities.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
	
	public Utilisateur saveUser(Utilisateur user);
	public Role saveRole(Role role);
	public void addRoleToUser(String username, String roleName);
    public Utilisateur findUserByUsername(String username);
}
