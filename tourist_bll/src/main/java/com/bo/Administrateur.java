package com.bo;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {
	
   
   public void addDestination(Destination d)
   {
      getDestinations().add(d);
   }
   
}