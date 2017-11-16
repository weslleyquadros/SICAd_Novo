package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;

import br.unitins.sac.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>{

	public UsuarioRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Usuario> getModelClass() {
		return Usuario.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select c From Usuario c Order by c.id Desc");
		List<Usuario> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Usuario>();
		
		return lista;

	}
	
}
