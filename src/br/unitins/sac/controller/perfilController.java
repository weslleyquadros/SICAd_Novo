package br.unitins.sac.controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;


import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Usuario;
import br.unitins.sac.repository.UsuarioRepository;

@ManagedBean
@ViewScoped
public class perfilController extends Controller<Usuario> {

	private Usuario usuarioLogado;
	
	
	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	@Override
	public Usuario getEntity() {
		if (entity == null) {
			entity = new Usuario();
		}
		return entity;
	}
	
	public Usuario getUsuarioLogado() {
		UsuarioRepository repo = new UsuarioRepository(JPAFactory.getEntityManager());

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		usuarioLogado = repo.buscarUsuarioPorLogin(external.getRemoteUser());
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public Validation<Usuario> getValidation() {
		return null;
	}

}