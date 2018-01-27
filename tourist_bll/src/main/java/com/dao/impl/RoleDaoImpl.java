package com.dao.impl;

import com.bo.Role;
import com.dao.RoleDao;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

public class RoleDaoImpl extends HibernateSpringGenericDaoImpl<Role, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
		
	}

}
