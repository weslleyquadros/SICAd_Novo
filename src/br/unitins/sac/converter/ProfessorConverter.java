package br.unitins.sac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.frame.application.ApplicationException;

import br.unitins.sac.factory.JPAFactory;

import br.unitins.sac.model.Professor;

import br.unitins.sac.repository.ProfessorRepository;

@FacesConverter(value = "professorConverter", forClass = Professor.class)
public class ProfessorConverter implements Converter  {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ProfessorRepository repository = new ProfessorRepository(JPAFactory.getEntityManager());
		try {
			Professor pr = ((Professor)repository.find(Integer.parseInt(arg2)));  
			return pr;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null) {
			System.out.println(arg2.getClass().getName());

			return ((Professor) arg2).getId() == null ? "":((Professor) arg2).getId().toString();
		}
		return "";
	}
}