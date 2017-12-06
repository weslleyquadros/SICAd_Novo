package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Disciplina;

public class DisciplinaRepository extends Repository<Disciplina>{

	public DisciplinaRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Disciplina> getModelClass() {
		return Disciplina.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select d From Disciplina d Order by d.id Desc");
		List<Disciplina> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Disciplina>();
		
		return lista;

	}
	
}
