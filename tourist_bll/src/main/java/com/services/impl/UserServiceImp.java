package com.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.bo.Role_tourist;
import com.bo.Utilisateur;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.services.UserService;

public class UserServiceImp implements UserService{

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	protected final Log log = LogFactory.getLog(getClass());
	
	
	public void addUtilisateur(Utilisateur user) 
	{

		for(Role_tourist role:roleDao.getAll())
		{
			if(role.getRoleName().equals("Internaute"))
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
	
	public Utilisateur loadUserByUsername(String pLogin)
	{
		Utilisateur lUser = null;
		lUser = userDao.getUserByLogin(pLogin);
		userDao.update(lUser);
		return lUser;
	}
	

}