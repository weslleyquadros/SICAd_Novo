package br.unitins.sac.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.model.Curso;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.repository.AlunoRepository;
import br.unitins.sac.repository.CidadeRepository;
import br.unitins.sac.repository.CursoRepository;
import br.unitins.sac.repository.PessoasRepository;
import br.unitins.sac.util.Report;
import br.unitins.sac.validation.AlunoValidation;
import br.unitins.sac.validation.CursoValidation;

@ManagedBean
@ViewScoped
public class CursoController extends Controller<Curso> {

	
	private List<Pessoas> listaPessoas;
	private List<Curso> listaCurso;
/*	
private Report relatorio;
	
	public Report getRelatorio() {
		if (relatorio == null) 
			relatorio = new Report("jdbc/web2", "reports", "AlunoReport");
		return relatorio;
	}*/
	
	@Override
	public Curso getEntity() {
		if (entity == null) {
			entity = new Curso();
			entity.setPessoas(new Pessoas());
		
		}
		return entity;
	}
	
	

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaCurso(null);
		
	}

	@Override
	public Validation<Curso> getValidation() {
		return new CursoValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Curso> getListaCurso() {
		if (listaCurso == null) {
			CursoRepository repository = new CursoRepository(JPAFactory.getEntityManager());
			listaCurso = repository.bucarTodos();
		}
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaServidor) {
		this.listaCurso = listaServidor;
	}



	

	public List<Pessoas> getListaPessoas() {
		if (listaPessoas == null) {
			PessoasRepository repository = new PessoasRepository(JPAFactory.getEntityManager());
			listaPessoas = repository.bucarTodos();
		}
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoas> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	

}
