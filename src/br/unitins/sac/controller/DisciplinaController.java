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
import br.unitins.sac.model.Disciplina;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.model.Professor;
import br.unitins.sac.repository.AlunoRepository;
import br.unitins.sac.repository.CidadeRepository;
import br.unitins.sac.repository.CursoRepository;
import br.unitins.sac.repository.DisciplinaRepository;
import br.unitins.sac.repository.PessoasRepository;
import br.unitins.sac.repository.ProfessorRepository;
import br.unitins.sac.util.Report;
import br.unitins.sac.validation.AlunoValidation;
import br.unitins.sac.validation.DisciplinaValidation;

@ManagedBean
@ViewScoped
public class DisciplinaController extends Controller<Disciplina> {

	private List<Professor> listaProfessor;
	private List<Curso> listaCurso;
	private List<Disciplina> listaDisciplina;

	private Report relatorio;

	public Report getRelatorio() {
		if (relatorio == null)
			relatorio = new Report("jdbc/web2", "reports", "DisciplinaReport");
		return relatorio;
	}

	@Override
	public Disciplina getEntity() {
		if (entity == null) {
			entity = new Disciplina();
			entity.setProfessor(new Professor());
			entity.setCurso(new Curso());

		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaDisciplina(null);
		setListaProfessor(null);
		setListaCurso(null);
	}

	@Override
	public Validation<Disciplina> getValidation() {
		return new DisciplinaValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Disciplina> getListaDisciplina() {
		if (listaDisciplina == null) {
			DisciplinaRepository repository = new DisciplinaRepository(JPAFactory.getEntityManager());
			listaDisciplina = repository.bucarTodos();
		}
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaServidor) {
		this.listaDisciplina = listaServidor;
	}

	public List<Professor> getListaProfessor() {
		if (listaProfessor == null) {
			ProfessorRepository repository = new ProfessorRepository(JPAFactory.getEntityManager());
			listaProfessor = repository.bucarTodos();
		}
		return listaProfessor;
	}

	public void setListaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}
	
	public List<Curso> getListaCurso() {
		if (listaCurso == null) {
			CursoRepository repository = new CursoRepository(JPAFactory.getEntityManager());
			listaCurso = repository.bucarTodos();
		}
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

}
