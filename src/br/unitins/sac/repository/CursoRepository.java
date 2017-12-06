package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.model.Curso;

public class CursoRepository extends Repository<Curso>{

	public CursoRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Curso> getModelClass() {
		return Curso.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select cu From Curso cu Order by cu.id Desc");
		List<Curso> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Curso>();
		
		return lista;

	}
	
}
