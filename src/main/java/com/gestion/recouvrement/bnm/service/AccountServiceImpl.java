package com.gestion.recouvrement.bnm.service;

import com.gestion.recouvrement.bnm.dao.RoleRepository;
import com.gestion.recouvrement.bnm.dao.UtilisateurRepository;
import com.gestion.recouvrement.bnm.entities.Role;
import com.gestion.recouvrement.bnm.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	// ce un bean spring qui sera instancier au demarage
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Utilisateur saveUser(Utilisateur user) {
		String Hahpw = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(Hahpw);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
    // Recherche du role dans la BD pour verifier l'existance
		Role role=roleRepository.findByRoleName(roleName);
		//charger l'utilisateur
		Utilisateur user=userRepository.findByUsername(username);
//puisque notre class est transactionnelle le role sera ajouter automatiquement
		user.getRoles().add(role);
	}

	@Override
	public Utilisateur findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

}
