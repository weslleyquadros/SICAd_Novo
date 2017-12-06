package br.unitins.sac.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unitins.frame.application.Util;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.repository.AlunoRepository;
import br.unitins.sac.repository.CidadeRepository;
import br.unitins.sac.repository.PessoasRepository;

@ManagedBean
@ViewScoped
public class RelatorioAlunoController  {

	private List<Aluno> listaAluno;
	private List<Cidade> listaCidade;
	private List<Pessoas> listaPessoas;
	private Cidade cidade;
	private Pessoas pessoas;

	public List<Aluno> getListaAluno() {
		if (listaAluno == null) {
			AlunoRepository repository = new AlunoRepository(JPAFactory.getEntityManager());
			if (getCidade().getId() == null)
				listaAluno = repository.bucarTodos();
			else
				listaAluno = repository.bucarPorCidade(getCidade().getId());
		}
		return listaAluno;
	}
	
	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repository.bucarTodos();
		}
		return listaCidade;
	}
	public List<Pessoas> getListaPessoas() {
		if (listaPessoas == null) {
			PessoasRepository repository = new PessoasRepository(JPAFactory.getEntityManager());
			listaPessoas = repository.bucarTodos();
		}
		return listaPessoas;
	}
	public void imprimir() {
		Util.redirectNewPage("AlunoRelatorio");
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	public void pesquisar() {
		listaAluno = null;
	}

	public Cidade getCidade() {
		if (cidade == null)
			cidade = new Cidade();
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Pessoas getPessoas() {
		if (pessoas == null)
			pessoas = new Pessoas();
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
		

}
