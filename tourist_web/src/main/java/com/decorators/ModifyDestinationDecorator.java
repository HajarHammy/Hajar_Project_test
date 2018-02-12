package com.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bo.Destination;

public class ModifyDestinationDecorator extends TableDecorator {

	public String getAddModifyLink() {

		Destination destination = (Destination) getCurrentRowObject();
		Long idprod = destination.getId();

		return "<a href=\"modify?id=" + idprod + "\">Supprimer une destination</a>";

	}

}