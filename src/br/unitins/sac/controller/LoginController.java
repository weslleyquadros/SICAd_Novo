package br.unitins.sac.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import br.unitins.frame.application.Session;
import br.unitins.frame.application.Util;
import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginController extends Controller<Usuario> {

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
	public void logar(ActionEvent actionEvent) {
		if (getEntity().getLogin().equals("janiojunior") && getEntity().getSenha().equals("123")) {
			getEntity().setNome("Jânio");
			Session.getSessionScope().put("usuarioLogado", getEntity());
			
			Util.redirect("pages/cadastroAluno.xhtml");
			
		} else {
			Util.warningMessage("Usuário ou Senha incorretos!");
		}
	}
	
	public void logout(ActionEvent actionEvent) {
		Session.encerrarSessao();
		Util.redirect("login.xhtml");
	}
	
	
}
