package br.unitins.sac.controller;



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Usuario;
import br.unitins.sac.repository.UsuarioRepository;
import br.unitins.sac.validation.UsuarioValidation;

@ManagedBean
@ViewScoped
public class UsuarioController extends Controller<Usuario> {
	
	private List<Usuario> listaUsuario;

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return new UsuarioValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaUsuario(null);
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
			listaUsuario = repository.bucarTodos();
		}
		return listaUsuario;
	}
	
	
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;}
	
}
