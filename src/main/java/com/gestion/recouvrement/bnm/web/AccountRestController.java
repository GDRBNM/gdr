package com.gestion.recouvrement.bnm.web;

import com.gestion.recouvrement.bnm.entities.Utilisateur;
import com.gestion.recouvrement.bnm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountRestController {
@Autowired
	private AccountService accountService;
    @PostMapping("/register")
	public Utilisateur register(@RequestBody RegisterForm userForm) {
    	if (!userForm.getPassword().equals(userForm.getRepassword()))
    		throw new RuntimeException("You Must Confirm Your password");
    	
    	//verification de l'existance de l'utilisateur
		Utilisateur user1=accountService.findUserByUsername(userForm.getUsername());
    	if(user1!=null) throw new RuntimeException("cet utilisateur exixte deja");
    		
    	//si tout est ok	
		Utilisateur user=new Utilisateur();
    	user.setUsername(userForm.getUsername());
    	user.setPassword(userForm.getPassword());
    	accountService.saveUser(user);
    	accountService.addRoleToUser(userForm.getUsername(),"USER");
    	return user;
	}
	
}
