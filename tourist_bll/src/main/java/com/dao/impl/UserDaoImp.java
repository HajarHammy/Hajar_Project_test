package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.bo.Utilisateur;
import com.dao.UserDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

public class UserDaoImp  extends HibernateSpringGenericDaoImpl<Utilisateur, Long> implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public UserDaoImp() {
		super(Utilisateur.class);
	}
	
	public Utilisateur getUserByLogin(String pLogin) {

		List users = hibernateTemplate.find(
				"from Utilisateur where login = ? ", pLogin);

		if (users == null || users.size() == 0 || users.size() != 1)
			throw new ObjectRetrievalFailureException(Utilisateur.class, pLogin);

		return (Utilisateur) users.get(0);
	}

}