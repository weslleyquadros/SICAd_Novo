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
		
		if (t.getNome() == null || t.getNome().trim().equals(""))
			getlistMessages().add("O nome deve ser informado!");
		
		if (t.getCpf() == null || t.getCpf().equals(""))
			getlistMessages().add("O cpf deve ser informado!");
		
		if (t.getRg() == null || t.getRg().equals(""))
			getlistMessages().add("O RG deve ser informado!");
		
		if (t.getEndereco() == null || t.getEndereco().equals(""))
			getlistMessages().add("O Endereço deve ser informado!");
		
		if (t.getTelefone() == null || t.getTelefone().equals(""))
			getlistMessages().add("O Telefone deve ser informado!");
		
		
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
