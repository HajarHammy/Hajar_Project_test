package com.web.actions.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Destination;
import com.services.DestinationService;
import com.web.actions.BaseAction;


public class AdminActions extends BaseAction {

	@Autowired
	private DestinationService destinationService;

	private List<Destination> destinations;

	private Destination destination;


	@Action(value = "/addDestination", results = { @Result(name = "success", location = "/private/admin/addDestinationForm.jsp") })
	public String addDestination() {

		destinationService.addDestination(destination);

		addActionMessage("Destination correctement ajoutée");

		return SUCCESS;

	}

	@Actions({
	@Action(value = "/", results = { @Result(name = "success", location = "/private/admin/listAdminDestinations.jsp") }),

	@Action(value = "/getAllAdminDestinations", results = { @Result(name = "success", location = "/private/admin/listAdminDestinations.jsp") })

	})

	public String getAllAdminDestinationss() {

		destinations = destinationService.getAllDestinations();

		return SUCCESS;

	}
	
	@Action(value = "/modify", results = { @Result(name = "success", location = "/private/admin/listAdminDestinations.jsp")

	})
	public String deleteDestination() {
		
		
		getSession().setAttribute("idDestination", Long.valueOf(getRequest().getParameter("id")));

		// On récupère l'id de la destination
		
		Long id = (Long) getSession().getAttribute("idDestination");
		
		
		destinationService.removeDestination( id );

		addActionMessage("Destination correctement supprimée");

		return SUCCESS;

	}
	

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
}
