package br.unitins.sac.validation;

import java.util.ArrayList;
import java.util.List;

import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.model.Usuario;;

public class UsuarioValidation implements Validation<Usuario> {
	List<String> listMessages;
	
	@Override
	public void validate(Usuario t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().equals(""))
			getlistMessages().add("O nome deve ser informado!");
		if (t.getLogin() == null || t.getLogin().equals(""))
			getlistMessages().add("O Login deve ser informado!");
		if (t.getEmail() == null || t.getEmail().equals(""))
			getlistMessages().add("O Email deve ser informado!");
		if (t.getSenha() == null || t.getSenha().equals(""))
			getlistMessages().add("A Senha deve ser informado!");
		
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
