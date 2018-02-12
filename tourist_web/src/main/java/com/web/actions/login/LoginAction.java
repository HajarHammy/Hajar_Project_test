package com.web.actions.login;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Utilisateur;
import com.services.UserService;
import com.web.actions.BaseAction;


@Results({ @Result(name = "login", location = "/public/Login.jsp") })
public class LoginAction extends BaseAction implements SessionAware  {
	private String userName;
	private String password;
	private Map<String, Object> session;
	
	@Autowired
	private UserService userService;
	
	@Action(value = "showLoginPage", results = { @Result(name = "success", location = "/public/Login.jsp") })
	public String showLoginPage() {

		return SUCCESS;
	}
	
	@Action(value = "loginAction", results = { @Result(name = "login", location = "/public/Login.jsp"),
			@Result(name = "success", type = "redirectAction", location = "initUserHome") })
	public String login() {

		// Si les champs sont vides (normalement il faut écrire un validateur
		// XML)
		if (userName.isEmpty() || password.isEmpty()) {
			addActionError("Username/Password ne peuvent pas etres vides");
			return LOGIN;
		}
		Utilisateur user = (Utilisateur) userService.loadUserByUsername(userName);
		if (user != null && password.equals(user.getMotPasse())) {

			// On met l'utilisateur dans la session
			session.put("user", user);

			// On redirige vers l'action qui initialise le home de
			// l'utilisateur
			return SUCCESS;
		} else {

			// Sinon enregistrer des erreurs pour les affichers dans la vue
			addActionError("Username ou Password incorrectes");
			return LOGIN;
		}
	}
	
	/** redirige l'utilisateur à son home */
	@Action(value = "initUserHome", results = { @Result(name = "successAdmin", location = "/private/admin/home.jsp"),
			@Result(name = "successUser", location = "/private/user/home.jsp") })
	public String initUserHome() {

		// On obtient l'utilisateur de la session
		Utilisateur user = (Utilisateur) session.get("user");
		// Si Admin
		if (user != null && user.getRole() != null && "Administrateur".equals(user.getRole().getRoleName())) {
			return "successAdmin";

		}
		// Si user
		else if (user != null && user.getRole() != null && "Internaute".equals(user.getRole().getRoleName())) {

			return "successUser";

		}

		// Si role inconnu
		return LOGIN;

	}
	
	
	
	public String getUserId() {
		return userName;
	}

	public void setUserId(String userId) {
		this.userName = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void setSession(Map<String, Object> pSession) {
		session = pSession;
		
	}
	
}
