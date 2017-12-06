package br.unitins.sac.validation;

import java.util.ArrayList;
import java.util.List;

import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Disciplina;

public class DisciplinaValidation implements Validation<Disciplina> {
	List<String> listMessages;
	
	@Override
	public void validate(Disciplina t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().trim().equals(""))
			getlistMessages().add("O nome deve ser informada!");
		if (t.getCarga_horaria() == null || t.getCarga_horaria().trim().equals(""))
			getlistMessages().add("A Carga_horaria deve ser informada!");
		
		if (t.getCarga_horaria() == null || t.getCarga_horaria().trim().equals(""))
			getlistMessages().add("A Carga_horaria deve ser informada!");
		if (t.getDescricao() == null || t.getDescricao().trim().equals(""))
			getlistMessages().add("A Descrição deve ser informada!");
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
