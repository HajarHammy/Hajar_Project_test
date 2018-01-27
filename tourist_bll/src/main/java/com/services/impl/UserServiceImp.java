package com.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Internaute;
import com.bo.Role;
import com.bo.Utilisateur;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.services.UserService;

public class UserServiceImp implements UserService{

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	public void addUtilisateur(Internaute user) 
	{

		for(Role role:roleDao.getAll())
		{
			if(role.getRole().equals("Internaute"))
			{
				user.setRole(role);
			}
		}
		    userDao.create(user);
	}

	public Utilisateur GetUser(String email, String password) 
	{
			for(Utilisateur user:userDao.getAll())
			{
				if(user.equals(email, password))
						{
					return userDao.findById(user.getId());
						}
			}
			return null;
	}

	
	
	

}
