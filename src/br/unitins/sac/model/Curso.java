package br.unitins.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Curso extends Model<Curso> {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4131373428533846312L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcurso")
	@SequenceGenerator(name = "seqidcurso", sequenceName = "seqidcurso", allocationSize = 1)
	private Integer id;
	private String nome;
	


	@JoinColumn(name = "idPessoas", nullable = true)
	private Pessoas pessoas;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
