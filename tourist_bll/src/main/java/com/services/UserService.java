package com.services;

import com.bo.Internaute;
import com.bo.Utilisateur;


public interface UserService 
{
		
	public void addUtilisateur(Internaute user);
	
	public Utilisateur GetUser(String email,String password);

}
