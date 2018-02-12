package com.dao;


import com.bo.Utilisateur;
import com.genericdao.api.GenericDao;

public interface UserDao extends GenericDao<Utilisateur, Long>{
	public Utilisateur getUserByLogin(String pString);
}