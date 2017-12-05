package br.unitins.sac.validation;

import java.util.ArrayList;
import java.util.List;

import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.model.Professor;

public class ProfessorValidation implements Validation<Professor> {
	List<String> listMessages;
	
	@Override
	public void validate(Professor t) throws ValidationException {
		
		if (t.getExperiencia() == null || t.getExperiencia().trim().equals(""))
			getlistMessages().add("A Experiencia deve ser informada!");
		
		
		
		if (getlistMessages().size() > 0)
			throw new ValidationException(getlistMessages());
	}

	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}

	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}
}
