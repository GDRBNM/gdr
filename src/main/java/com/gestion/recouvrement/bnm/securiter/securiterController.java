package com.gestion.recouvrement.bnm.securiter;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(description = "gestion de la securiter")
@Controller
public class securiterController {

	@RequestMapping("/login")
	public String login() 
	{
		return "login";
	}
	
/*
	@RequestMapping("/")
	public String home() 
	{
		return "redirect:/entreprises";
	}
*/
	@RequestMapping("/403")
	public String accesdenied() 
	{
		return "403";
	}
	
	
}
