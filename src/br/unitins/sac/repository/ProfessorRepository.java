package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.unitins.sac.model.Professor;

public class ProfessorRepository extends Repository<Professor>{

	public ProfessorRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Professor> getModelClass() {
		return Professor.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select pr From Professor pr Order by pr.id Desc");
		List<Professor> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Professor>();
		
		return lista;

	}
	
}
