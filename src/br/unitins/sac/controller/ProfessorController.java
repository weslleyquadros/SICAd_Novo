package br.unitins.sac.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;

import br.unitins.sac.model.Cidade;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.model.Professor;

import br.unitins.sac.repository.CidadeRepository;
import br.unitins.sac.repository.PessoasRepository;
import br.unitins.sac.repository.ProfessorRepository;

import br.unitins.sac.validation.ProfessorValidation;

@ManagedBean
@ViewScoped
public class ProfessorController extends Controller<Professor> {

	private List<Cidade> listaCidade;
	private List<Pessoas> listaPessoas;
	private List<Professor> listaProfessor;

	@Override
	public Professor getEntity() {
		if (entity == null) {
			entity = new Professor();
			entity.setPessoas(new Pessoas());
			entity.setCidade(new Cidade());
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaProfessor(null);
		setListaCidade(null);
		setListaProfessor(null);
	}

	@Override
	public Validation<Professor> getValidation() {
		return new ProfessorValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Professor> getListaProfessor() {
		if (listaProfessor == null) {
			ProfessorRepository repository = new ProfessorRepository(JPAFactory.getEntityManager());
			listaProfessor = repository.bucarTodos();
		}
		return listaProfessor;
	}

	public void setListaProfessor(List<Professor> listaServidor) {
		this.listaProfessor = listaServidor;
	}


	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repository.bucarTodos();
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
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
