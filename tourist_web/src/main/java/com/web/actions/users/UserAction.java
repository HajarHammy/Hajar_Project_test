package com.web.actions.users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bo.Commentaire;
import com.bo.Destination;
import com.services.DestinationService;
import com.web.actions.BaseAction;



public class UserAction extends BaseAction {

	@Autowired
	private DestinationService destinationService;

	private List<Destination> destinations;

	private Destination destination;

	private Commentaire userComment;
	
	public static Integer uploadsFileName= 0;
	
	private String uploadsContentType;
	
	private File upload;


	@Action(value = "/addDestination", results = { @Result(name = "success", location = "/private/user/addDestinationForm.jsp") })
	public String addDestination() {

		destinationService.addDestination(destination);

		addActionMessage("Destination correctement ajoutée");

		return SUCCESS;

	}
	@Action(value = "/addFileUpload", results = { @Result(name = "success", location = "/private/user/addDestinationForm.jsp") })
	public String addFileUpload() 
	{
		FileInputStream fis;
		FileOutputStream fos;
		try {
			fis = new FileInputStream(upload);
		   
			++UserAction.uploadsFileName;
			this.setUploadsContentType(upload.getName());
			String contentType = getUploadsContentType();
			System.out.println(contentType);
		   
			String path= "C:\\Users\\Hajar\\git\\Hajar_Project_test1\\tourist_web"+"/src/main/webapp/img"+getUploadsFileName().toString()+".jpg";
		   
			fos=new FileOutputStream(path);
		   
			byte[] b =new byte[1024];
			while(fis.read(b) != -1)
			{
				fos.write(b);
			}
		   
			fos.close();
			fis.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	   
		destination.setImage(getUploadsFileName().toString());
		destinationService.addDestination(destination);
		return SUCCESS;
	   
   }

	@Actions({
	@Action(value = "/", results = { @Result(name = "success", location = "/private/user/listDestinations.jsp") }),

	@Action(value = "/getAllDestinations", results = { @Result(name = "success", location = "/private/user/listDestinations.jsp") })

	})

	public String getAllDestinationss() {

		destinations = destinationService.getAllDestinations();

		return SUCCESS;

	}

	@Action(value = "/commenter", results = { @Result(name = "success", location = "/private/user/addCommentForm.jsp")

	})
	public String showAddCommentForm() {

		// On récupère l'id de la destination

		getSession().setAttribute("idDestination", Long.valueOf(getRequest().getParameter("id")));

		return SUCCESS;

	}

	@Action(value = "/addComment", results = {
			@Result(name = "success", type = "redirectAction", location = "getAllDestinations")

	})
	public String addComment() {

		// On récupère de la session la destination

		Long id = (Long) getSession().getAttribute("idDestination");

		// TODO : si destination est introuvable
		Destination destination = destinationService.getDestinationById(id);

		destination.addCommentaire(userComment);

		destinationService.updateDestination(destination);

		return SUCCESS;

	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public Commentaire getUserComment() {
		return userComment;
	}

	public void setUserComment(Commentaire userComment) {
		this.userComment = userComment;
	}
	public static Integer getUploadsFileName() {
		return uploadsFileName;
	}

	public static void setUploadsFileName(Integer uploadsFileName) {
		UserAction.uploadsFileName = uploadsFileName;
	}

	public String getUploadsContentType() {
		return uploadsContentType;
	}

	public void setUploadsContentType(String uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	

}